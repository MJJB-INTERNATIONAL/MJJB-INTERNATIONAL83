cmake_minimum_required(VERSION 3.22.1)
project("mjjbserver")

add_library(
    mjjbserver
    SHARED
    mjjb_server.cpp
)

target_link_libraries(
    mjjbserver
    android
    log
)