/********************************************************************************
** Form generated from reading UI file 'recordshow.ui'
**
** Created by: Qt User Interface Compiler version 5.13.2
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_RECORDSHOW_H
#define UI_RECORDSHOW_H

#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QLabel>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_RecordShow
{
public:
    QLabel *label;
    QLabel *label_2;
    QLabel *label_3;

    void setupUi(QWidget *RecordShow)
    {
        if (RecordShow->objectName().isEmpty())
            RecordShow->setObjectName(QString::fromUtf8("RecordShow"));
        RecordShow->resize(192, 202);
        RecordShow->setStyleSheet(QString::fromUtf8(""));
        label = new QLabel(RecordShow);
        label->setObjectName(QString::fromUtf8("label"));
        label->setGeometry(QRect(40, 140, 111, 31));
        label->setStyleSheet(QString::fromUtf8("color: rgb(255, 255, 255);\n"
"font: 16pt \"\345\276\256\350\275\257\351\233\205\351\273\221\";"));
        label_2 = new QLabel(RecordShow);
        label_2->setObjectName(QString::fromUtf8("label_2"));
        label_2->setGeometry(QRect(50, 30, 91, 91));
        label_2->setPixmap(QPixmap(QString::fromUtf8(":/image/\351\272\246\345\205\213\351\243\216.png")));
        label_2->setScaledContents(true);
        label_3 = new QLabel(RecordShow);
        label_3->setObjectName(QString::fromUtf8("label_3"));
        label_3->setGeometry(QRect(1, 5, 231, 191));
        label_3->setPixmap(QPixmap(QString::fromUtf8(":/image/bg/black.png")));
        label_3->raise();
        label->raise();
        label_2->raise();

        retranslateUi(RecordShow);

        QMetaObject::connectSlotsByName(RecordShow);
    } // setupUi

    void retranslateUi(QWidget *RecordShow)
    {
        RecordShow->setWindowTitle(QCoreApplication::translate("RecordShow", "Form", nullptr));
        label->setText(QCoreApplication::translate("RecordShow", "\346\235\276\345\274\200\345\217\221\351\200\201", nullptr));
        label_2->setText(QString());
        label_3->setText(QString());
    } // retranslateUi

};

namespace Ui {
    class RecordShow: public Ui_RecordShow {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_RECORDSHOW_H
