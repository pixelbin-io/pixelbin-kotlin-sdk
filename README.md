# Pixelbin kotlin library

Pixelbin kotlin library helps you integrate Pixelbin with your Android Application.

## Usage

### Setup

Add the dependency

```
// gradle
dependencies {
//for latest version 
implementation 'io.pixelbin:pixelbin-kotlin-sdk:version'
//for below 0.0.10 version
implementation 'io.github.pixelbin-dev:pixelbin-kotlin-sdk:version'
}
```

For other artifacts check this link
[pixelbin-kotlin-sdk](https://mvnrepository.com/artifact/io.pixelbin/pixelbin-kotlin-sdk)

- Import the Pixelbin class

```
import io.pixelbin:pixelbin-kotlin-sdk.*
```

- Create your instance

```
val pixelbin = PixelBin.getInstance()
val image = pixelbin.url("https://cdn.pixelbin.io/v2/cloudName/z-slug/transformation/path/to/image.jpeg")
val image = pixelbin.url(
    UrlObj(
        baseUrl = baseUrl,
        version = version,
        cloudName = cloudName,
        zone = zone,
        transformation = transformationList,
        filePath = imagePath
    )
)
```

______________________________________________________________________

### Transform and Optimize Images

Import transformations

```
import io.pixelbin.sdk_kotlin.Transformation
val eraseTransformation = Transformation.erasebg();
// Create a new instance. If you have't (see above for the details)
val pixelbin = PixelBin.getInstance()
val image = pixelbin.url(imageUrl)
// Create EraseBg.bg transformation
// Kotlin
val t1 = Transformation.erasebg();
//Java
TransformationObj t1 = Transformation.INSTANCE.erasebg();
// Create resize transformation
// Kotlin
val t2 = Transformation.tResize(height = 100,width = 100)
//Java
TransformationObj t2 = Transformation.INSTANCE.tResize(height = 100,width = 100);
// Add the transformations to the image object
//add single transformation
image.addTransformation(t1);
//or add multiple transformation
//Kotlin
image.addTransformation(arrayListOf(t1,t2));
//Java
ArrayList<TransformationObj> list = new ArrayList<>();
list.add(t1);
list.add(t2);
image.add(list);
// Get the image url
image.getUrl()
// output
// https://cdn.pixelbin.io/v2/cloudName/z-slug/erase.bg()~t.resize(h:100,w:100)/path/to/image.jpeg
```

### upload(file, signedDetails,callback,chunkSize,concurrency):

| parameter                                                            | type                                                                                                                                 |
| -------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------ |
| file ([File](https://developer.mozilla.org/en-US/docs/Web/API/File)) | File to upload to Pixelbin                                                                                                           |
| signedDetails (Object)                                               | `signedDetails` can be generated with the Pixelbin Backend SDK [@pixelbin/admin](https://github.com/pixelbin-dev/pixelbin-js-admin). |
| chunkSize (int)                                                      | size of chunks to be uploaded in kb. default value is 1024.                                                                          |\
|                                                                      | Recommended chunk size for                                                                                                           |\
|                                                                      |     3g network - upto 5kb                                                                                                            |
|                                                                      |     4g network - 500kb to 1MB                                                                                                        |\
|                                                                      |     5g network - 1MB to 2MB                                                                                                          |
| concurrency (int)                                                    |  number of chunks to be uploaded in parallel api calls                                                                               |

- Resolves with no response on success.
- Rejects with error on failure.
  Example :

1. Define a file element

```
val file =  File(pathname);
```

2. Use the presignedUrl generated with the backend sdk. [click here](https://github.com/pixelbin-dev/pixelbin-js-admin/blob/main/documentation/platform/ASSETS.md#createsignedurl).

```
val signedDetails = SignedDetails(url = "url", fields = fieldsToHashMap(fields))
//fields refer to hashmap of fields object which we got from signed url api 
Example
data class Fields(
    @SerializedName("x-goog-meta-assetdata") var xGoogMetaAssetData: String? = null,
    @SerializedName("x-goog-meta-token") var xGoogMetaToken: String? = null,
    @SerializedName("Access-Control-Request-Headers") var headers: String? = null,
    @SerializedName("Content-Type") var contentType: String? = null,
    //for pixelbin host
    @SerializedName("x-pixb-meta-assetdata") var xPixbMetaAssetdata: String? = null
)
fun fieldsToHashMap(fields: Fields): HashMap<String, String> {
        val hashMap = HashMap<String, String>()
        hashMap["x-goog-meta-assetData"] = fields.xGoogMetaAssetData?:""
        hashMap["x-goog-meta-token"] = fields.xGoogMetaToken?:""
        hashMap["Access-Control-Request-Headers"] = fields.headers?:""
        hashMap["Content-Type"] = fields.contentType?:""
        //for pixelbin host
        hashMap["x-pixb-meta-assetdata"] = fields.xPixbMetaAssetdata?:""
        return hashMap
}
//for kotlin
CoroutineScope(Dispatchers.IO).launch {
    PixelBin.getInstance().upload(file, details, {
        when (it) {
            is com.pixelbin.upload.Result.Success -> {
                val response = it.data
            }
            is com.pixelbin.upload.Result.Failure -> {
                val response = it.response
            }
            is com.pixelbin.upload.Result.Error -> {
                val exception = it.exception
            }
            else -> {}
        }
    }, chunkSize, concurrency)
}
//for java
  pixelbin.upload(file,signedDetails, result->{
  //here Result class is from com.pixelbin.upload.Result
      if (result instanceof Result.Success) {
                System.out.println("Upload successful");
          } else if (result instanceof Result.Failure) {
                Result.Failure failure = (Result.Failure) result;
                System.out.println("Upload failed: " + failure.getResponse());
            } else if (result instanceof Result.Error) {
                Result.Error error = (Result.Error) result;
                System.out.println("Error during upload: " + error.getException().getMessage());
            }
            return null;
        },chunkSize, concurrency);
```

## Utilities

Import the utils class

```
import com.pixelbin.Utils
```

Pixelbin provides url utilities to construct and deconstruct Pixelbin urls.

### urlToObj

Deconstruct a pixelbin url
| parameter                | description                                               | example                                                                                               |
|--------------------------|-----------------------------------------------------------|-------------------------------------------------------------------------------------------------------|
| pixelbinUrl (string)     | A valid pixelbin url                                      | `https://cdn.pixelbin.io/v2/your-cloud-name/z-slug/t.resize(h:100,w:200)~t.flip()/path/to/image.jpeg` |
| isCustomDomain (boolean) | Indicates if the URL belongs to a custom domain (default) | `false`                                                                                               |
**Returns**:
| property                 | description                                               | example                              |
|--------------------------|-----------------------------------------------------------|--------------------------------------|
| cloudName (string)       | The cloudname extracted from the url                      | `your-cloud-name`                    |
| zone (string)            | 6 character zone slug                                     | `z-slug`                             |
| version (string)         | cdn api version                                           | `v2`                                 |
| transformations (array)  | Extracted transformations from the url                    |                                      |
| filePath                 | Path to the file on Pixelbin storage                      | `/path/to/image.jpeg`                |
| baseUrl (string)         | Base url                                                  | `https://cdn.pixelbin.io/`           |
| worker (boolean)         | Indicates if the URL is a URL Translation Worker URL      | `false`                              |
| workerPath (string)      | Input path to a URL Translation Worker                    | `resize:w200,h400/folder/image.jpeg` |
| options (Object)         | Query parameters added, such as "dpr" and "f_auto"        | `{ dpr: 2.5, f_auto: true}`          |
| isCustomDomain (boolean) | Indicates if the URL belongs to a custom domain (default) | `false`                              |
Example:

```
val pixelbinUrl =
    "https://cdn.pixelbin.io/v2/your-cloud-name/z-slug/t.resize(h:100,w:200)~t.flip()/path/to/image.jpeg";
//string representation of url object
//name of transformation = plugin+"."+name
val obj = Utils.urlToUrlObj(pixelbinUrl)
//        UrlObj(
//            baseUrl = "https://cdn.pixelbin.io/",
//            version = "v2",
//            cloudName = "your-cloud-name",
//            transformation= arrayListOf(
//                TransformationObj(
//                    plugin = "t",
//                    name = "resize",
//                    values= hashMapOf(
//                      "w" to "200",
//                      "h" to "100",
//                   )
//                ),
//                TransformationObj(
//                    plugin = "t",
//                    name = "flip",
//                )
//                            ),
//                zone =" z-slug",
//            filePath = "path/to/image.jpeg",
//            wrkr = false;  
//            workerPath = ";  
//        )
```

```
val pixelbinUrl =
    "https://xyz.designify.media/v2/your-cloud-name/z-slug/t.resize(h:100,w:200)~t.flip()/path/to/image.jpeg";
val obj = Utils.urlToUrlObj(url=pixelbinUrl, isCustomDomain = true)
//        UrlObj(
//            baseUrl = "https://cdn.pixelbin.io/",
//            version = "v2",
//            cloudName = "your-cloud-name",
//            transformation= arrayListOf(
//                TransformationObj(
//                    plugin = "t",
//                    name = "resize",
//                    values= hashMapOf(
//                      "w" to "200",
//                      "h" to "100",
//                   )
//                ),
//                TransformationObj(
//                    plugin = "t",
//                    name = "flip",
//                )
//                            ),
//            zone =" z-slug",
//            filePath = "path/to/image.jpeg",
//            isCustomDomain = true  
//            wrkr = false;  
//            workerPath = ";  
//        )
```

```
val pixelbinUrl =
    "https://cdn.pixelbin.io/v2/your-cloud-name/z-slug/t.resize(h:100,w:200)~t.flip()/path/to/image.jpeg?dpr=2.0&f_auto=True";
//string representation of url object
//name of transformation = plugin+"."+name
val obj = Utils.urlToUrlObj(pixelbinUrl)
//        UrlObj(
//            baseUrl = "https://cdn.pixelbin.io/",
//            version = "v2",
//            cloudName = "your-cloud-name",
//            transformation = arrayListOf(
//                TransformationObj(
//                    plugin = "t",
//                    name = "resize",
//                    values= hashMapOf(
//                      "w" to "200",
//                      "h" to "100",
//                      )
//                ),
//                TransformationObj(
//                    plugin="t",
//                    name="flip",
//                )
//                            ),
//            zone = "z-slug",
//            options = hashMapOf(
//                  "dpr" to "2.0",
//                  "f_auto" to "true"
//              ),
//            filePath = "path/to/image.jpeg",  
//            wrkr = false;  
//            workerPath = ";  
//        )
```

```
val pixelbinUrl =
    "https://cdn.pixelbin.io/v2/your-cloud-name/z-slug/wrkr/t.resize(h:100,w:200)~t.flip()/path/to/image.jpeg?dpr=2.0&f_auto=True";
//string representation of url object
//name of transformation = plugin+"."+name
val obj = Utils.urlToUrlObj(pixelbinUrl)
//        UrlObj(
//            baseUrl = "https://cdn.pixelbin.io/",
//            version = "v2",
//            cloudName = "your-cloud-name",
//            transformation = arrayListOf<TransformationObj>(),
//            zone = "z-slug",
//            options = hashMapOf(
//                  "dpr" to "2.0",
//                  "f_auto" to "true"
//              ),
//            filePath = "",  
//            wrkr = true;  
//            workerPath = "t.resize(h:100,w:200)~t.flip()/path/to/image.jpeg";  
//        )
```

### objToUrl

Converts the extracted url obj to a Pixelbin url.
| property                  | description                                               | example                              |
|---------------------------|-----------------------------------------------------------|--------------------------------------|
| cloudName (string)        | The cloudname extracted from the url                      | `your-cloud-name`                    |
| zone (string)             | 6 character zone slug                                     | `z-slug`                             |
| version (string)          | cdn api version                                           | `v2`                                 |
| transformations (array)   | Extracted transformations from the url                    |                                      |
| filePath                  | Path to the file on Pixelbin storage                      | `/path/to/image.jpeg`                |
| baseUrl (string)          | Base url                                                  | `https://cdn.pixelbin.io/`           |
| worker (boolean)          | Indicates if the URL is a URL Translation Worker URL      | `false`                              |
| workerPath (string)       | Input path to a URL Translation Worker                    | `resize:w200,h400/folder/image.jpeg` |
| options (Object)          | Query parameters added, such as "dpr" and "f_auto"        | `{ dpr: 2.5, f_auto: true}`          |
| isCustomDomain (boolean)  | Indicates if the URL belongs to a custom domain (default) | `false`                              |
Example

```
val obj = UrlObj(
    cloudName = "your-cloud-name",
    zone = "z-slug",
    version = "v2",
    transformation = arrayListOf(
               TransformationObj(
                    plugin = "t",
                    name = "resize",
                    values= hashMapOf(
                       "w" to "200",
                       "h" to "100",
                    )
                ),
                TransformationObj(
                    plugin = "t",
                    name = "flip",
                )
    ),
    filePath = "path/to/image.jpeg",
    baseUrl = "https://cdn.pixelbin.io"
)
val url = Utils.objToUrl(pixelbinUrl) // obj is as shown above
// url
// https://cdn.pixelbin.io/v2/your-cloud-name/z-slug/t.resize(h:100,w:200)~t.flip()/path/to/image.jpeg
```

```
val obj = UrlObj(
    cloudName = "your-cloud-name",
    zone = "z-slug",
    version = "v2",
    transformation = arrayListOf(
               TransformationObj(
                    plugin = "t",
                    name = "resize",
                    values= hashMapOf(
                       "w" to "200",
                       "h" to "100",
                    )
                ),
                TransformationObj(
                    plugin = "t",
                    name = "flip()",
                )
    ),
    filePath = "path/to/image.jpeg",
    baseUrl = "https://cdn.pixelbin.io",
    options = hashMapOf(
        "dpr" to "2.0",
        "f_auto" to "true"
    )
)
val url = Utils.objToUrl(obj)  // obj is as shown above
// url
// https://cdn.pixelbin.io/v2/your-cloud-name/z-slug/t.resize(h:100,w:200)~t.flip()/path/to/image.jpeg?dpr=2.0&f_auto=True
```

```
val obj = UrlObj(
              baseUrl = "https://cdn.pixelbin.io/",
              version = "v2",
              cloudName = "your-cloud-name",
              transformation = arrayListOf<TransformationObj>(),
              zone = "z-slug",
              options = hashMapOf(
                    "dpr" to "2.0",
                    "f_auto" to "true"
                ),
              filePath = "",  
              wrkr = true;  
              workerPath = "t.resize(h:100,w:200)~t.flip()/path/to/image.jpeg";  
          )
val url = Utils.objToUrl(obj)          
//url
//"https://cdn.pixelbin.io/v2/your-cloud-name/z-slug/wrkr/t.resize(h:100,w:200)~t.flip()/path/to/image.jpeg?dpr=2.0&f_auto=True";
```

## List of supported transformations

### DetectBackgroundType

#### 1. dbtDetect()

Classifies the background of a product as plain, clean or busy

```kotlin
val t = Transformation.dbtDetect(
)
```

### Basic

#### 1. tResize(height, width, fit, background, position, algorithm, dpr)

Basic Transformations
| Parameter | Type | Default |
|-----------|------|---------|
| height | integer | 0 |
| width | integer | 0 |
| fit | enum: `cover`, `contain`, `fill`, `inside`, `outside` | TResize.Fit.COVER |
| background | color | "000000" |
| position | enum: `top`, `bottom`, `left`, `right`, `right_top`, `right_bottom`, `left_top`, `left_bottom`, `center` | TResize.Position.CENTER |
| algorithm | enum: `nearest`, `cubic`, `mitchell`, `lanczos2`, `lanczos3` | TResize.Algorithm.LANCZOS3 |
| dpr | float | 1 |

```kotlin
val t = Transformation.tResize(
 height = 0,
 width = 0,
 fit = TResize.Fit.COVER,
 background = "000000",
 position = TResize.Position.CENTER,
 algorithm = TResize.Algorithm.LANCZOS3,
 dpr = 1
)
```

#### 2. tCompress(quality)

Basic Transformations
| Parameter | Type | Default |
|-----------|------|---------|
| quality | integer | 80 |

```kotlin
val t = Transformation.tCompress(
 quality = 80
)
```

#### 3. tExtend(top, left, bottom, right, background, borderType, dpr)

Basic Transformations
| Parameter | Type | Default |
|-----------|------|---------|
| top | integer | 10 |
| left | integer | 10 |
| bottom | integer | 10 |
| right | integer | 10 |
| background | color | "000000" |
| borderType | enum: `constant`, `replicate`, `reflect`, `wrap` | TExtend.Bordertype.CONSTANT |
| dpr | float | 1 |

```kotlin
val t = Transformation.tExtend(
 top = 10,
 left = 10,
 bottom = 10,
 right = 10,
 background = "000000",
 bordertype = TExtend.Bordertype.CONSTANT,
 dpr = 1
)
```

#### 4. tExtract(top, left, height, width, boundingBox)

Basic Transformations
| Parameter | Type | Default |
|-----------|------|---------|
| top | integer | 10 |
| left | integer | 10 |
| height | integer | 50 |
| width | integer | 20 |
| boundingBox | bbox | ="" |

```kotlin
val t = Transformation.tExtract(
 top = 10,
 left = 10,
 height = 50,
 width = 20,
 boundingbox=""
)
```

#### 5. tTrim(threshold)

Basic Transformations
| Parameter | Type | Default |
|-----------|------|---------|
| threshold | integer | 10 |

```kotlin
val t = Transformation.tTrim(
 threshold = 10
)
```

#### 6. tRotate(angle, background)

Basic Transformations
| Parameter | Type | Default |
|-----------|------|---------|
| angle | integer | 0 |
| background | color | "000000" |

```kotlin
val t = Transformation.tRotate(
 angle = 0,
 background = "000000"
)
```

#### 7. tFlip()

Basic Transformations

```kotlin
val t = Transformation.tFlip(
)
```

#### 8. tFlop()

Basic Transformations

```kotlin
val t = Transformation.tFlop(
)
```

#### 9. tSharpen(sigma)

Basic Transformations
| Parameter | Type | Default |
|-----------|------|---------|
| sigma | float | 1.5 |

```kotlin
val t = Transformation.tSharpen(
 sigma = 1.5
)
```

#### 10. tMedian(size)

Basic Transformations
| Parameter | Type | Default |
|-----------|------|---------|
| size | integer | 3 |

```kotlin
val t = Transformation.tMedian(
 size = 3
)
```

#### 11. tBlur(sigma, dpr)

Basic Transformations
| Parameter | Type | Default |
|-----------|------|---------|
| sigma | float | 0.3 |
| dpr | float | 1 |

```kotlin
val t = Transformation.tBlur(
 sigma = 0.3,
 dpr = 1
)
```

#### 12. tFlatten(background)

Basic Transformations
| Parameter | Type | Default |
|-----------|------|---------|
| background | color | "000000" |

```kotlin
val t = Transformation.tFlatten(
 background = "000000"
)
```

#### 13. tNegate()

Basic Transformations

```kotlin
val t = Transformation.tNegate(
)
```

#### 14. tNormalise()

Basic Transformations

```kotlin
val t = Transformation.tNormalise(
)
```

#### 15. tLinear(a, b)

Basic Transformations
| Parameter | Type | Default |
|-----------|------|---------|
| a | integer | 1 |
| b | integer | 0 |

```kotlin
val t = Transformation.tLinear(
 a = 1,
 b = 0
)
```

#### 16. tModulate(brightness, saturation, hue)

Basic Transformations
| Parameter | Type | Default |
|-----------|------|---------|
| brightness | float | 1 |
| saturation | float | 1 |
| hue | integer | 90 |

```kotlin
val t = Transformation.tModulate(
 brightness = 1,
 saturation = 1,
 hue = 90
)
```

#### 17. tGrey()

Basic Transformations

```kotlin
val t = Transformation.tGrey(
)
```

#### 18. tTint(color)

Basic Transformations
| Parameter | Type | Default |
|-----------|------|---------|
| color | color | "000000" |

```kotlin
val t = Transformation.tTint(
 color = "000000"
)
```

#### 19. tToformat(format, quality)

Basic Transformations
| Parameter | Type | Default |
|-----------|------|---------|
| format | enum: `jpeg`, `png`, `webp`, `tiff`, `avif`, `bmp`, `heif` | TToformat.Format.JPEG |
| quality | enum: `100`, `95`, `90`, `85`, `80`, `75`, `70`, `60`, `50`, `40`, `30`, `20`, `10`, `best`, `good`, `eco`, `low` | TToformat.Quality.\_75 |

```kotlin
val t = Transformation.tToformat(
 format = TToformat.Format.JPEG,
 quality = TToformat.Quality._75
)
```

#### 20. tDensity(density)

Basic Transformations
| Parameter | Type | Default |
|-----------|------|---------|
| density | integer | 300 |

```kotlin
val t = Transformation.tDensity(
 density = 300
)
```

#### 21. tMerge(mode, image, transformation, background, height, width, top, left, gravity, blend, tile, listOfBboxes, listOfPolygons)

Basic Transformations
| Parameter | Type | Default |
|-----------|------|---------|
| mode | enum: `overlay`, `underlay`, `wrap` | TMerge.Mode.OVERLAY |
| image | file | "" |
| transformation | custom | "" |
| background | color | "00000000" |
| height | integer | 0 |
| width | integer | 0 |
| top | integer | 0 |
| left | integer | 0 |
| gravity | enum: `northwest`, `north`, `northeast`, `east`, `center`, `west`, `southwest`, `south`, `southeast`, `custom` | TMerge.Gravity.CENTER |
| blend | enum: `over`, `in`, `out`, `atop`, `dest`, `dest-over`, `dest-in`, `dest-out`, `dest-atop`, `xor`, `add`, `saturate`, `multiply`, `screen`, `overlay`, `darken`, `lighten`, `colour-dodge`, `color-dodge`, `colour-burn`, `color-burn`, `hard-light`, `soft-light`, `difference`, `exclusion` | TMerge.Blend.OVER |
| tile | boolean | false |
| listOfBboxes | bboxList | ="" |
| listOfPolygons | polygonList | ="" |

```kotlin
val t = Transformation.tMerge(
 mode = TMerge.Mode.OVERLAY,
 image = "",
 transformation = "",
 background = "00000000",
 height = 0,
 width = 0,
 top = 0,
 left = 0,
 gravity = TMerge.Gravity.CENTER,
 blend = TMerge.Blend.OVER,
 tile = false,
 listofbboxes="",
 listofpolygons=""
)
```

### Artifact

#### 1. afRemove()

Artifact Removal Plugin

```kotlin
val t = Transformation.afRemove(
)
```

### AWSRekognitionPlugin

#### 1. awsrekDetectlabels(maximumLabels, minimumConfidence)

Detect objects and text in images
| Parameter | Type | Default |
|-----------|------|---------|
| maximumLabels | integer | 5 |
| minimumConfidence | integer | 55 |

```kotlin
val t = Transformation.awsrekDetectlabels(
 maximumlabels = 5,
 minimumconfidence = 55
)
```

#### 2. awsrekModeration(minimumConfidence)

Detect objects and text in images
| Parameter | Type | Default |
|-----------|------|---------|
| minimumConfidence | integer | 55 |

```kotlin
val t = Transformation.awsrekModeration(
 minimumconfidence = 55
)
```

### BackgroundGenerator

#### 1. generateBg(backgroundPrompt, focus, negativePrompt, seed)

AI Background Generator
| Parameter | Type | Default |
|-----------|------|---------|
| backgroundPrompt | custom | "YSBmb3Jlc3QgZnVsbCBvZiBvYWsgdHJlZXMsd2l0aCBicmlnaHQgbGlnaHRzLCBzdW4gYW5kIGEgbG90IG9mIG1hZ2ljLCB1bHRyYSByZWFsaXN0aWMsIDhr" |
| focus | enum: `Product`, `Background` | GenerateBg.Focus.PRODUCT |
| negativePrompt | custom | "" |
| seed | integer | 123 |

```kotlin
val t = Transformation.generateBg(
 backgroundprompt = "YSBmb3Jlc3QgZnVsbCBvZiBvYWsgdHJlZXMsd2l0aCBicmlnaHQgbGlnaHRzLCBzdW4gYW5kIGEgbG90IG9mIG1hZ2ljLCB1bHRyYSByZWFsaXN0aWMsIDhr",
 focus = GenerateBg.Focus.PRODUCT,
 negativeprompt = "",
 seed = 123
)
```

### ImageExtender

#### 1. bgExtend(boundingBox, prompt, negativePrompt, strength, guidanceScale, numberOfInferenceSteps, colorAdjust, seed)

AI Image Extender
| Parameter | Type | Default |
|-----------|------|---------|
| boundingBox | bbox | ="" |
| prompt | custom | "" |
| negativePrompt | custom | "" |
| strength | float | 0.999 |
| guidanceScale | integer | 8 |
| numberOfInferenceSteps | integer | 10 |
| colorAdjust | boolean | false |
| seed | integer | 123 |

```kotlin
val t = Transformation.bgExtend(
 boundingbox="",
 prompt = "",
 negativeprompt = "",
 strength = 0.999,
 guidancescale = 8,
 numberofinferencesteps = 10,
 coloradjust = false,
 seed = 123
)
```

### VariationGenerator

#### 1. vgGenerate(generateVariationPrompt, noOfVariations, seed, autoscale)

AI Variation Generator
| Parameter | Type | Default |
|-----------|------|---------|
| generateVariationPrompt | custom | "" |
| noOfVariations | integer | 1 |
| seed | integer | 0 |
| autoscale | boolean | true |

```kotlin
val t = Transformation.vgGenerate(
 generatevariationprompt = "",
 noofvariations = 1,
 seed = 0,
 autoscale = true
)
```

### EraseBG

#### 1. eraseBg(industryType, addShadow, refine)

EraseBG Background Removal Module
| Parameter | Type | Default |
|-----------|------|---------|
| industryType | enum: `general`, `ecommerce`, `car`, `human`, `object` | EraseBg.Industrytype.GENERAL |
| addShadow | boolean | false |
| refine | boolean | true |

```kotlin
val t = Transformation.eraseBg(
 industrytype = EraseBg.Industrytype.GENERAL,
 addshadow = false,
 refine = true
)
```

### GoogleVisionPlugin

#### 1. googlevisDetectlabels(maximumLabels)

Detect content and text in images
| Parameter | Type | Default |
|-----------|------|---------|
| maximumLabels | integer | 5 |

```kotlin
val t = Transformation.googlevisDetectlabels(
 maximumlabels = 5
)
```

### ImageCentering

#### 1. imcDetect(distancePercentage)

Image Centering Module
| Parameter | Type | Default |
|-----------|------|---------|
| distancePercentage | integer | 10 |

```kotlin
val t = Transformation.imcDetect(
 distancepercentage = 10
)
```

### IntelligentCrop

#### 1. icCrop(requiredWidth, requiredHeight, paddingPercentage, maintainOriginalAspect, aspectRatio, gravityTowards, preferredDirection, objectType)

Intelligent Crop Plugin
| Parameter | Type | Default |
|-----------|------|---------|
| requiredWidth | integer | 0 |
| requiredHeight | integer | 0 |
| paddingPercentage | integer | 0 |
| maintainOriginalAspect | boolean | false |
| aspectRatio | string | "" |
| gravityTowards | enum: `object`, `foreground`, `face`, `none` | IcCrop.Gravitytowards.NONE |
| preferredDirection | enum: `north_west`, `north`, `north_east`, `west`, `center`, `east`, `south_west`, `south`, `south_east` | IcCrop.Preferreddirection.CENTER |
| objectType | enum: `airplane`, `apple`, `backpack`, `banana`, `baseball_bat`, `baseball_glove`, `bear`, `bed`, `bench`, `bicycle`, `bird`, `boat`, `book`, `bottle`, `bowl`, `broccoli`, `bus`, `cake`, `car`, `carrot`, `cat`, `cell_phone`, `chair`, `clock`, `couch`, `cow`, `cup`, `dining_table`, `dog`, `donut`, `elephant`, `fire_hydrant`, `fork`, `frisbee`, `giraffe`, `hair_drier`, `handbag`, `horse`, `hot_dog`, `keyboard`, `kite`, `knife`, `laptop`, `microwave`, `motorcycle`, `mouse`, `orange`, `oven`, `parking_meter`, `person`, `pizza`, `potted_plant`, `refrigerator`, `remote`, `sandwich`, `scissors`, `sheep`, `sink`, `skateboard`, `skis`, `snowboard`, `spoon`, `sports_ball`, `stop_sign`, `suitcase`, `surfboard`, `teddy_bear`, `tennis_racket`, `tie`, `toaster`, `toilet`, `toothbrush`, `traffic_light`, `train`, `truck`, `tv`, `umbrella`, `vase`, `wine_glass`, `zebra` | IcCrop.Objecttype.PERSON |

```kotlin
val t = Transformation.icCrop(
 requiredwidth = 0,
 requiredheight = 0,
 paddingpercentage = 0,
 maintainoriginalaspect = false,
 aspectratio = "",
 gravitytowards = IcCrop.Gravitytowards.NONE,
 preferreddirection = IcCrop.Preferreddirection.CENTER,
 objecttype = IcCrop.Objecttype.PERSON
)
```

### IntelligentMasking

#### 1. imMask(replacementImage, detector, maskType)

Intelligent Masking
| Parameter | Type | Default |
|-----------|------|---------|
| replacementImage | file | "" |
| detector | enum: `face`, `text`, `number_plate` | ImMask.Detector.NUMBER_PLATE |
| maskType | enum: `fill_black`, `pixelate`, `blur` | ImMask.Masktype.FILL_BLACK |

```kotlin
val t = Transformation.imMask(
 replacementimage = "",
 detector = ImMask.Detector.NUMBER_PLATE,
 masktype = ImMask.Masktype.FILL_BLACK
)
```

### ObjectCounter

#### 1. ocDetect()

Classifies whether objects in the image are single or multiple

```kotlin
val t = Transformation.ocDetect(
)
```

### NSFWDetection

#### 1. nsfwDetect(minimumConfidence)

Detect NSFW content in images
| Parameter | Type | Default |
|-----------|------|---------|
| minimumConfidence | float | 0.5 |

```kotlin
val t = Transformation.nsfwDetect(
 minimumconfidence = 0.5
)
```

### NumberPlateDetection

#### 1. numplateDetect()

Number Plate Detection Plugin

```kotlin
val t = Transformation.numplateDetect(
)
```

### ObjectDetection

#### 1. odDetect()

Detect bounding boxes of objects in the image

```kotlin
val t = Transformation.odDetect(
)
```

### CheckObjectSize

#### 1. cosDetect(objectThresholdPercent)

Calculates the percentage of the main object area relative to image dimensions.
| Parameter | Type | Default |
|-----------|------|---------|
| objectThresholdPercent | integer | 50 |

```kotlin
val t = Transformation.cosDetect(
 objectthresholdpercent = 50
)
```

### TextDetectionandRecognition

#### 1. ocrExtract(detectOnly)

OCR Module
| Parameter | Type | Default |
|-----------|------|---------|
| detectOnly | boolean | false |

```kotlin
val t = Transformation.ocrExtract(
 detectonly = false
)
```

### PdfWatermarkRemoval

#### 1. pwrRemove()

PDF Watermark Removal Plugin

```kotlin
val t = Transformation.pwrRemove(
)
```

### ProductTagging

#### 1. prTag()

AI Product Tagging

```kotlin
val t = Transformation.prTag(
)
```

### CheckProductVisibility

#### 1. cpvDetect()

Classifies whether the product in the image is completely visible or not

```kotlin
val t = Transformation.cpvDetect(
)
```

### QRCode

#### 1. qrGenerate(width, height, image, margin, qRTypeNumber, qrErrorCorrectionLevel, imageSize, imageMargin, dotsColor, dotsType, dotsBgColor, cornerSquareColor, cornerSquareType, cornerDotsColor, cornerDotsType)

QRCode Plugin
| Parameter | Type | Default |
|-----------|------|---------|
| width | integer | 300 |
| height | integer | 300 |
| image | custom | "" |
| margin | integer | 0 |
| qRTypeNumber | integer | 0 |
| qrErrorCorrectionLevel | enum: `L`, `M`, `Q`, `H` | QrGenerate.Qrerrorcorrectionlevel.Q |
| imageSize | float | 0.4 |
| imageMargin | integer | 0 |
| dotsColor | color | "000000" |
| dotsType | enum: `rounded`, `dots`, `classy`, `classy-rounded`, `square`, `extra-rounded` | QrGenerate.Dotstype.SQUARE |
| dotsBgColor | color | "ffffff" |
| cornerSquareColor | color | "000000" |
| cornerSquareType | enum: `dot`, `square`, `extra-rounded` | QrGenerate.Cornersquaretype.SQUARE |
| cornerDotsColor | color | "000000" |
| cornerDotsType | enum: `dot`, `square` | QrGenerate.Cornerdotstype.DOT |

```kotlin
val t = Transformation.qrGenerate(
 width = 300,
 height = 300,
 image = "",
 margin = 0,
 qrtypenumber = 0,
 qrerrorcorrectionlevel = QrGenerate.Qrerrorcorrectionlevel.Q,
 imagesize = 0.4,
 imagemargin = 0,
 dotscolor = "000000",
 dotstype = QrGenerate.Dotstype.SQUARE,
 dotsbgcolor = "ffffff",
 cornersquarecolor = "000000",
 cornersquaretype = QrGenerate.Cornersquaretype.SQUARE,
 cornerdotscolor = "000000",
 cornerdotstype = QrGenerate.Cornerdotstype.DOT
)
```

#### 2. qrScan()

QRCode Plugin

```kotlin
val t = Transformation.qrScan(
)
```

### RemoveBG

#### 1. removeBg()

Remove background from any image

```kotlin
val t = Transformation.removeBg(
)
```

### SoftShadowGenerator

#### 1. shadowGen(backgroundImage, backgroundColor, shadowAngle, shadowIntensity)

AI Soft Shadow Generator
| Parameter | Type | Default |
|-----------|------|---------|
| backgroundImage | file | ="" |
| backgroundColor | color | "ffffff" |
| shadowAngle | float | 120 |
| shadowIntensity | float | 0.5 |

```kotlin
val t = Transformation.shadowGen(
 backgroundimage="",
 backgroundcolor = "ffffff",
 shadowangle = 120,
 shadowintensity = 0.5
)
```

### SuperResolution

#### 1. srUpscale(type, enhanceFace, model, enhanceQuality)

Super Resolution Module
| Parameter | Type | Default |
|-----------|------|---------|
| type | enum: `2x`, `4x`, `8x` | SrUpscale.Type.\_2X |
| enhanceFace | boolean | false |
| model | enum: `Picasso`, `Flash` | SrUpscale.Model.PICASSO |
| enhanceQuality | boolean | false |

```kotlin
val t = Transformation.srUpscale(
 type = SrUpscale.Type._2X,
 enhanceface = false,
 model = SrUpscale.Model.PICASSO,
 enhancequality = false
)
```

### VertexAI

#### 1. vertexaiGeneratebg(backgroundPrompt, negativePrompt, seed, guidanceScale)

Vertex AI based transformations
| Parameter | Type | Default |
|-----------|------|---------|
| backgroundPrompt | custom | "YSBmb3Jlc3QgZnVsbCBvZiBvYWsgdHJlZXMsd2l0aCBicmlnaHQgbGlnaHRzLCBzdW4gYW5kIGEgbG90IG9mIG1hZ2ljLCB1bHRyYSByZWFsaXN0aWMsIDhr" |
| negativePrompt | custom | "" |
| seed | integer | 22 |
| guidanceScale | integer | 60 |

```kotlin
val t = Transformation.vertexaiGeneratebg(
 backgroundprompt = "YSBmb3Jlc3QgZnVsbCBvZiBvYWsgdHJlZXMsd2l0aCBicmlnaHQgbGlnaHRzLCBzdW4gYW5kIGEgbG90IG9mIG1hZ2ljLCB1bHRyYSByZWFsaXN0aWMsIDhr",
 negativeprompt = "",
 seed = 22,
 guidancescale = 60
)
```

#### 2. vertexaiRemovebg()

Vertex AI based transformations

```kotlin
val t = Transformation.vertexaiRemovebg(
)
```

#### 3. vertexaiUpscale(type)

Vertex AI based transformations
| Parameter | Type | Default |
|-----------|------|---------|
| type | enum: `x2`, `x4` | VertexaiUpscale.Type.X2 |

```kotlin
val t = Transformation.vertexaiUpscale(
 type = VertexaiUpscale.Type.X2
)
```

### VideoWatermarkRemoval

#### 1. wmvRemove()

Video Watermark Removal Plugin

```kotlin
val t = Transformation.wmvRemove(
)
```

### VideoUpscalerPlugin

#### 1. vsrUpscale()

Video Upscaler Plugin

```kotlin
val t = Transformation.vsrUpscale(
)
```

### ViewDetection

#### 1. vdDetect()

Classifies wear type and view type of products in the image

```kotlin
val t = Transformation.vdDetect(
)
```

### WatermarkRemoval

#### 1. wmRemove(removeText, removeLogo, box1, box2, box3, box4, box5)

Watermark Removal Plugin
| Parameter | Type | Default |
|-----------|------|---------|
| removeText | boolean | false |
| removeLogo | boolean | false |
| box1 | string | "0_0_100_100" |
| box2 | string | "0_0_0_0" |
| box3 | string | "0_0_0_0" |
| box4 | string | "0_0_0_0" |
| box5 | string | "0_0_0_0" |

```kotlin
val t = Transformation.wmRemove(
 removetext = false,
 removelogo = false,
 box1 = "0_0_100_100",
 box2 = "0_0_0_0",
 box3 = "0_0_0_0",
 box4 = "0_0_0_0",
 box5 = "0_0_0_0"
)
```

### WatermarkDetection

#### 1. wmcDetect(detectText)

Watermark Detection Plugin
| Parameter | Type | Default |
|-----------|------|---------|
| detectText | boolean | false |

```kotlin
val t = Transformation.wmcDetect(
 detecttext = false
)
```
