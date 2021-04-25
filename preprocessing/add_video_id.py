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

    columns = ['start_time', 'end_time', 'content', 'video_id']
    data_df = pd.DataFrame(columns=columns)

    for csv in pbar:
        pbar.set_description("Processing %s" % csv)

        filename = csv.split("/")[-1]
        video_id = filename.split(".")[0]

        try:
            df = pd.read_csv(csv, sep=";")

            video_data['id'].append(video_id)

            # new_start = data_df['start_time'].append(df['Start time in milliseconds'], ignore_index=True).rename(
            #     'start_time')
            # new_end = data_df['end_time'].append(df['End time in milliseconds'], ignore_index=True).rename('end_time')
            # new_content = data_df['content'].append(df['Text'], ignore_index=True).rename('content')
            # new_video = data_df['video_id'].append(pd.Series(video_id, index=df.index), ignore_index=True).rename(
            #     'video_id')

            new_start = df['Start time in milliseconds'].rename('start_time')
            new_end = df['End time in milliseconds'].rename('end_time')
            new_content = df['Text'].rename('content')
            new_video = pd.Series(video_id, index=df.index).rename('video_id')

            data_df = data_df.append(pd.concat([new_start, new_end, new_content, new_video], axis=1), ignore_index=True)

            # data_df.columns = ['start_time', 'end_time', 'content', 'video_id']

        except pd.errors.ParserError:
            errors.append(csv)

    video_df = pd.DataFrame(video_data)
    video_df.to_csv(output_folder + "videos.csv", index=False)

    # filtering out nans
    data_df.dropna(inplace=True)

    data_df.start_time = data_df.start_time.astype('int64')
    data_df.end_time = data_df.end_time.astype('int64')

    # data_df.start_time = pd.to_numeric(data_df.start_time, downcast='integer')
    # data_df.end_time = pd.to_numeric(data_df.end_time, downcast='integer')
    data_df.to_csv((output_folder + "transcripts.csv"), index=False)

    # f = open("logs.txt", "a")

    print("Total errors: ", len(errors))
    print("Errors in these files: ")
    for error in errors:
        # f.write(error + "\n")
        print(error)

    # f.close()
