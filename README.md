# Team Members

1. Gleb Cirkov (122002)

2. Fathima Shafana (121985)

3. Htoo Lwin (Leader) (120832)

# Project Topic

## Ctrl+VID (or) Ctrl+F (Control-ef)
A platform where students can search any word or phrase they are interested in, and the search engine will retrieve video-lectures with exact timestamps when the phrase was said. The platform allows users to upload video and audio. After the upload, the platform generates a video specific transcript used for searching. The transcript may be edited by some users*.

## Architecture

TBD

## Implementation Details

TBD

## Quality Attribute Analysis

| Quality Attribute | Priority | Reason |
| ----------- | ----------- | ----------- |
| Availability | H | The platform's main purpose is to provide aid in the learning process, so it should be available as much as possible. It should not fail the student when he needs it. |
| Performance | H | When a student is learning, it is important not to lose focus. So, the platform's search function should work as quickly as possible. |
| Portability | L | As the majority of quality studying is done in front of a desk, the software architecture should be designed for desktop computers (Windows PC, Mac OS). |
| Security | M | The main function - searching - only retrieves data, which is not dangerous. But uploading and transcript editing should be done only by authorized personnel. The software should provide that. |
| Scalability | H | As this platform is basically a database, any kind of expansion (most likely vertical) should be seamless and unnoticed by the user.
| Testability | M | The functionality is quite simple and input methods are limited. The upload formats (video and audio) are also limited. The only functionality that should be tested thoroughly is the transcript generation. |

## Team Responsibilites

| Module | Member |
| ----------- | ----------- |
| Web Application | Gleb Cirkov |
| Database | Htoo Lwin |
| Transcript Generator | Fathima Shafana |

## Meeting Schedule

Weekly - Fridays at 15.00 GMT+7.00.

**Note**: Will increase in regularity as workload increases.

Regular communication mechanism: Line.

Issue tracker: TBD

## Timetable

!(https://github.com/AdamHtooLwin/control-ef/blob/master/Project%20Plan.PNG)

## Progress

Web Application ![0%](https://progress-bar.dev/0)

Database ![0%](https://progress-bar.dev/0)

Transcript Generator ![0%](https://progress-bar.dev/0)

---

\* Subject to change for the next two weeks.
