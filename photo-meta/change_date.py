import os
import piexif
from PIL import Image
from datetime import datetime, date

# calculate the date difference 

date_delta = date(2019,6,2) - date(2015,2,7)

dest_dir = '/Users/binshi/Downloads/new_photo/'


def change_exif_date(file, date_delta):
    photo = Image.open(file)
    exif_dict = piexif.load(photo.info['exif'])
    exif_bytes = piexif.dump(exif_dict)
    
    filename = os.path.basename(file)
    name, ext = os.path.splitext(filename)
    new_file = dest_dir + name + ext

    print('Processing photo: ', file, 'and save it to', new_file)

    for ifd in ("0th", "Exif", "GPS", "1st"):
        for tag in exif_dict[ifd]:
    #         print(piexif.TAGS[ifd][tag]["name"], exif_dict[ifd][tag])
            if piexif.TAGS[ifd][tag]["name"].startswith('DateTime'):
                att_name = piexif.TAGS[ifd][tag]["name"]
                original_date = exif_dict[ifd][tag].decode('utf-8')
                modified_date = datetime.strptime(original_date, '%Y:%m:%d %H:%M:%S') + date_delta
                
                modified_date_bytes = modified_date.strftime('%Y:%m:%d %H:%M:%S').encode('utf-8')
                exif_dict[ifd][tag] = modified_date_bytes
                exif_bytes = piexif.dump(exif_dict)
                
                print(att_name, original_date, 'was changed to', modified_date.strftime('%Y:%m:%d %H:%M:%S'))
                
    photo.save(new_file , "jpeg", exif=exif_bytes, quality=100)


photo_dir = '/Volumes/SONY/Olympic/'
for _, _, files in os.walk(photo_dir):
    for f in files:
        if f.endswith('jpg') or f.endswith('JPG') or f.endswith('jpeg') or f.endswith('JPEG'): continue
        change_exif_date(photo_dir + f, date_delta)
