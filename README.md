# bitmap-transformer

# bitmap-transformer



`input`: Path to the input image file.
- `output`: Path to save the transformed image.
- `transform`: Choose from "transform1" (reverseBlackAndGreen), "transform2" (flipVertically), or "transform3" (resizeImage).
- `width`: New width for resizing (only for "transform3").
- `height`: New height for resizing (only for "transform3").



you can write in the cmd this command :
./gradlew run --args "input.bmp output.bmp transform width height"
## first transform (transform1)
<pre>
Reverse Black and Green:
.gradlew.bat run --args "C:\Users\CW\Bitmap-transformer\app\src\main\resources\JavaLogo.bmp   C:\Users\CW\Bitmap-transformer\app\src\main\resources\JavaLogoEdit.bmp transform1 0 0"
</pre>
## second transform (transform2)
<pre>
flip vertically

 .gradlew.bat run --args "C:\Users\CW\Bitmap-transformer\app\src\main\resources\JavaLogo.bmp   C:\Users\CW\Bitmap-transformer\app\src\main\resources\JavaLogoEdit.bmp transform2 0 0"
</pre>

## third transform (transform3)
<pre>
resize Image
gradlew.bat run --args "C:\Users\CW\Bitmap-transformer\app\src\main\resources\JavaLogo.bmp   C:\Users\CW\Bitmap-transformer\app\src\main\resources\JavaLogoEdit.bmp transform3 0 0"
</pre>










