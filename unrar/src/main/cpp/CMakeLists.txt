# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.18.1)

# Declares and names the project.

project("unrar")

add_subdirectory(libunrar)
include_directories(libunrar)
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -DLITTLE_ENDIAN")
set(CMAKE_CXX_FLAGS_RELEASE "${CMAKE_CXX_FLAGS_RELEASE} -fvisibility=hidden")

add_library( # Sets the name of the library.
        unrar
        SHARED
        unrar.cpp rar_file.cpp jni_init.c)

# Searches for a specified prebuilt library and stores the path as a
# variable. Because CMake includes system libraries in the search path by
# default, you only need to specify the name of the public NDK library
# you want to add. CMake verifies that the library exists before
# completing its build.

find_library( # Sets the name of the path variable.
        log-lib

        # Specifies the name of the NDK library that
        # you want CMake to locate.
        log)

# Specifies libraries CMake should link to your target library. You
# can link multiple libraries, such as libraries you define in this
# build script, prebuilt third-party libraries, or system libraries.
target_include_directories(unrar PRIVATE ${CMAKE_SOURCE_DIR})
target_link_libraries( # Specifies the target library.
        unrar
        static_unrar
        ${log-lib})