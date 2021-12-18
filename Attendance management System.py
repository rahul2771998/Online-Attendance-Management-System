
# coding: utf-8

# In[1]:


import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
from keras.models import Sequential
from keras.layers import Conv2D
from keras.layers import MaxPooling2D
from keras.layers import Flatten
from keras.layers import Dense
from keras.preprocessing.image import ImageDataGenerator
from keras.preprocessing import image

classifier=Sequential()

classifier.add(Conv2D(32,(3,3),input_shape=(64,64,3),activation='relu'))
classifier.add(MaxPooling2D(pool_size=(2,2)))
classifier.add(Flatten())
classifier.add(Dense(output_dim=128,activation='relu'))
classifier.add(Dense(output_dim=5,activation='sigmoid'))

classifier.compile(optimizer='adam',loss='binary_crossentropy',metrics=['accuracy'])

train_datagen=ImageDataGenerator(rescale=1./255,shear_range=0.2,zoom_range=0.2,horizontal_flip=True)

test_datagen=ImageDataGenerator(rescale=1./255)


training_set=train_datagen.flow_from_directory('C:/Users/pc/Downloads/Datasets/training',target_size=(64,64),batch_size=32,class_mode='categorical')

test_set=test_datagen.flow_from_directory('C:/Users/pc/Downloads/Datasets/testing',target_size=(64,64),batch_size=32,class_mode='categorical')
from IPython.display import display
from PIL import Image
classifier.fit_generator(training_set,steps_per_epoch=260,epochs=5,validation_data=test_set,validation_steps=260)


# In[27]:




import mysql.connector
import cv2
import numpy as np
import matplotlib.pyplot as plt
import time
start_time=time.time()


def updateAttendance(name):
    mycursor=mysql.connector.connect(user='root', password='', host='localhost', database='smartclass')
    dict2={'Rahul':1,'Nitish':2,'Amit':3,'Sachin':4,'Nilabh':5,'Unknown':6}
    
    mycursor.execute("update Attendance  set count=count+1 where scholar_no=dict2[name] and status='Active'")
    #mycursor.execute("select count from Attendance where scholar_no=dict2[name] and status='Active'")
    
    
def predict(test_image):
    img=test_image
    test_image=image.img_to_array(test_image)
   
    test_image=np.expand_dims(test_image,axis=0)
    result=classifier.predict(test_image)
   
    if result[0][0]==1:
        return "Amit"
    elif result[0][1]==1: 
        return "Nilabh"
    elif result[0][2]==1:
        return "Nitish"
    elif result[0][3]==1:
        return "Rahul"
    
    else:   
        return "Sachin"
        

import cv2
import numpy as np
import matplotlib.pyplot as plt
# Load HAAR face classifier
face_cascade = cv2.CascadeClassifier(cv2.data.haarcascades + 'haarcascade_frontalface_default.xml')

image = cv2.imread('C:/Users/pc/Downloads/Datasets/group.jpg') 

gray = cv2.cvtColor(image,cv2.COLOR_BGR2GRAY)

faces = face_cascade.detectMultiScale(gray, 1.3, 5)

if faces is ():
    print("No faces found")


        
i=1
for (x,y,w,h) in faces:
    cv2.rectangle(image, (x,y), (x+w,y+h), (127,0,255), 3)
    path='C:/Users/pc/Downloads/Datasets/Amit/amit ('+str(i)+'.jpg'
    cv2.imwrite(path,image[y:y + h, x:x + w])
    fn_name=predict(image)
    i+=1
    print(fn_name)
    updateAttendance(fn_name)
    cv2.putText(image, fn_name, (x - 5, y - 5), cv2.FONT_HERSHEY_PLAIN,1,(0, 255, 0))
    cv2.imshow('Face Detection', image)
    plt.imshow(image)
       
    cv2.waitKey(0)
    
cv2.destroyAllWindows()

print("Attendance Update Successfully")
t1=time.time()-start_time

print("total execution time :",t1,sep=" ")

