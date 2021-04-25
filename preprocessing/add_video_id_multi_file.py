import os
import argparse
import glob
from tqdm import tqdm

import pandas as pd


def make_folder(folder):
    if not os.path.isdir(folder):
        os.makedirs(folder)


if __name__ == "__main__":
    parser = argparse.ArgumentParser(
            description='Extract frames from OULU videos.',
            formatter_class=argparse.ArgumentDefaultsHelpFormatter
    )

    parser.add_argument('csvs_folder', type=str, help='Absolute path to folder to process csvs.')

    args = parser.parse_args()

    csv_files = glob.glob(args.csvs_folder + "/*.csv")

    output_folder = args.csvs_folder.rstrip("/") + "/output/"
    make_folder(output_folder)

    pbar = tqdm(csv_files)

    video_data = {
        'id': [],
    }

    errors = []

    for csv in pbar:
        pbar.set_description("Processing %s" % csv)

        filename = csv.split("/")[-1]
        video_id = filename.split(".")[0]

        try:
            df = pd.read_csv(csv, sep=";")

            video_data['id'].append(video_id)

            df.drop('Number', 1, inplace=True)

            df.columns = ['start_time', 'end_time', 'content']

            df['video_id'] = pd.Series(video_id, index=df.index)

            df.to_csv(output_folder + filename, index=False)
        except pd.errors.ParserError:
            errors.append(csv)

    video_df = pd.DataFrame(video_data)
    video_df.to_csv(output_folder + "videos.csv", index=False)

    f = open("logs.txt", "a")

    print("Total errors: ", len(errors))
    print("Errors in these files: ")
    for error in errors:
        f.write(error + "\n")
        print(error)

    f.close()
