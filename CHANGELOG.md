## 0.0.11

- Release version 0.0.11 bring minor changes

# 0.0.10

- Updated method names and add new transformations methods.

# 0.0.9

**Breaking change:**

- Updated return response for upload(file, signedDetails,callback,chunkSize,concurrency) API
- On success, `response.data` will now return an instance UploadResponse instead String.

# 0.0.8

- backward compatibility to gcs
- abstracting different file upload methods to single method

# 0.0.7

- added support for file upload on 3g network

# 0.0.6

- retry support in case of timeout connection

# 0.0.5

- Added new plugins
  - `NSFW Detection` - Detect NSFW content in images.
  - `ObjectDetection` - Detect bounding boxes of objects in the image.
  - `ViewDetection` - Classifies wear type and view type of products in the image
  - `CustomDomain` support added
  - `worker url` support added

# 0.0.4

- Transformations are updated to their latest API
- Added support for GCS signed URL uploads
