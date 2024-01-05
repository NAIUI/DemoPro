﻿#include "filecontext.h"
#include <QDebug>
#include <QDesktopServices>
#include <QUrl>
#include <QFileInfo>
#include <QMessageBox>
FileContext::FileContext()
{

}

void FileContext::Download(QString realname,QString filename ,qint64 size){
    emit doDownload(realname,filename,size);
}

void FileContext::Open(QString name){
    QDesktopServices::openUrl(QUrl::fromLocalFile(QFileInfo("tmp/"+name).absoluteFilePath()));
}

void FileContext::withDraw(QString mid){
    emit withDrawMsg(mid);

}

void FileContext::Garb(QString mid){
    emit garb(mid);
}

void FileContext::playSpeak(QString fname){
    emit play(fname);
}
