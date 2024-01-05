#-------------------------------------------------
#
# Project created by QtCreator 2018-07-26T15:22:23
#
#-------------------------------------------------

QT       += core gui websockets
QT      += network multimedia
RC_ICONS = logo.ico
greaterThan(QT_MAJOR_VERSION, 4): QT += widgets

TARGET = Login
TEMPLATE = app

# The following define makes your compiler emit warnings if you use
# any feature of Qt which has been marked as deprecated (the exact warnings
# depend on your compiler). Please consult the documentation of the
# deprecated API in order to know how to port your code away from it.
DEFINES += QT_DEPRECATED_WARNINGS

# You can also make your code fail to compile if you use deprecated APIs.
# In order to do so, uncomment the following line.
# You can also select to disable deprecated APIs only up to a certain version of Qt.
#DEFINES += QT_DISABLE_DEPRECATED_BEFORE=0x060000    # disables all the APIs deprecated before Qt 6.0.0


SOURCES += \
    ../../../Telegraph/Telegraph/src/messagethread.cpp \
    home.cpp \
        main.cpp \
        mainwindow.cpp \
    regwindow.cpp \
    loginthread.cpp \
    messagethread.cpp \
    useritem.cpp \
    message.cpp \
    dialog.cpp \
    purchase.cpp \
    filecontext.cpp \
    creatgroup.cpp \
    dialog/editprofile.cpp \
    dialog/stylechange.cpp \
    dialog/normalred.cpp \
    dialog/garbresult.cpp \
    dialog/luckyred.cpp \
    dialog/recordshow.cpp \
    dialog/biaoqingselect.cpp

HEADERS += \
    home.h \
        mainwindow.h \
    regwindow.h \
    loginthread.h \
    messagethread.h \
    useritem.h \
    message.h \
    dialog.h \
    purchase.h \
    filecontext.h \
    creatgroup.h \
    dialog/editprofile.h \
    dialog/stylechange.h \
    dialog/normalred.h \
    dialog/garbresult.h \
    dialog/luckyred.h \
    dialog/recordshow.h \
    dialog/biaoqingselect.h

FORMS += \
    home.ui \
        mainwindow.ui \
    regwindow.ui \
    useritem.ui \
    dialog.ui \
    purchase.ui \
    creatgroup.ui \
    dialog/editprofile.ui \
    dialog/stylechange.ui \
    dialog/normalred.ui \
    dialog/garbresult.ui \
    dialog/luckyred.ui \
    dialog/recordshow.ui \
    dialog/biaoqingselect.ui

RESOURCES += \
    res.qrc
