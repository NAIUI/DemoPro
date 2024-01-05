/********************************************************************************
** Form generated from reading UI file 'garbresult.ui'
**
** Created by: Qt User Interface Compiler version 5.13.2
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_GARBRESULT_H
#define UI_GARBRESULT_H

#include <QtCore/QVariant>
#include <QtGui/QIcon>
#include <QtWidgets/QApplication>
#include <QtWidgets/QDialog>
#include <QtWidgets/QLabel>

QT_BEGIN_NAMESPACE

class Ui_GarbResult
{
public:
    QLabel *label;
    QLabel *label_2;
    QLabel *label_3;
    QLabel *label_4;
    QLabel *label_5;
    QLabel *label_6;
    QLabel *label_7;

    void setupUi(QDialog *GarbResult)
    {
        if (GarbResult->objectName().isEmpty())
            GarbResult->setObjectName(QString::fromUtf8("GarbResult"));
        GarbResult->resize(601, 404);
        QIcon icon;
        icon.addFile(QString::fromUtf8(":/image/ico"), QSize(), QIcon::Normal, QIcon::Off);
        GarbResult->setWindowIcon(icon);
        label = new QLabel(GarbResult);
        label->setObjectName(QString::fromUtf8("label"));
        label->setGeometry(QRect(0, -10, 601, 421));
        label->setPixmap(QPixmap(QString::fromUtf8(":/image/bg/result.png")));
        label_2 = new QLabel(GarbResult);
        label_2->setObjectName(QString::fromUtf8("label_2"));
        label_2->setGeometry(QRect(135, 258, 141, 51));
        label_2->setStyleSheet(QString::fromUtf8("font: 20pt \"\345\276\256\350\275\257\351\233\205\351\273\221\";"));
        label_3 = new QLabel(GarbResult);
        label_3->setObjectName(QString::fromUtf8("label_3"));
        label_3->setGeometry(QRect(275, 264, 81, 41));
        label_3->setStyleSheet(QString::fromUtf8("font: 20pt \"\345\276\256\350\275\257\351\233\205\351\273\221\";\n"
"color: rgb(255, 75, 90);"));
        label_3->setAlignment(Qt::AlignCenter);
        label_4 = new QLabel(GarbResult);
        label_4->setObjectName(QString::fromUtf8("label_4"));
        label_4->setGeometry(QRect(371, 264, 71, 41));
        label_4->setStyleSheet(QString::fromUtf8("font: 20pt \"\345\276\256\350\275\257\351\233\205\351\273\221\";"));
        label_5 = new QLabel(GarbResult);
        label_5->setObjectName(QString::fromUtf8("label_5"));
        label_5->setGeometry(QRect(160, 340, 281, 16));
        label_5->setAlignment(Qt::AlignCenter);
        label_6 = new QLabel(GarbResult);
        label_6->setObjectName(QString::fromUtf8("label_6"));
        label_6->setGeometry(QRect(130, 260, 311, 51));
        label_6->setStyleSheet(QString::fromUtf8("font: 20pt \"\345\276\256\350\275\257\351\233\205\351\273\221\";"));
        label_6->setAlignment(Qt::AlignCenter);
        label_7 = new QLabel(GarbResult);
        label_7->setObjectName(QString::fromUtf8("label_7"));
        label_7->setGeometry(QRect(240, 130, 100, 100));
        QSizePolicy sizePolicy(QSizePolicy::Fixed, QSizePolicy::Fixed);
        sizePolicy.setHorizontalStretch(0);
        sizePolicy.setVerticalStretch(0);
        sizePolicy.setHeightForWidth(label_7->sizePolicy().hasHeightForWidth());
        label_7->setSizePolicy(sizePolicy);
        label_7->setMinimumSize(QSize(100, 100));
        label_7->setMaximumSize(QSize(100, 100));
        label_7->setStyleSheet(QString::fromUtf8(""));
        label_7->setPixmap(QPixmap(QString::fromUtf8(":/image/smile.png")));
        label_7->setScaledContents(true);

        retranslateUi(GarbResult);

        QMetaObject::connectSlotsByName(GarbResult);
    } // setupUi

    void retranslateUi(QDialog *GarbResult)
    {
        GarbResult->setWindowTitle(QCoreApplication::translate("GarbResult", "\346\212\242\347\272\242\345\214\205", nullptr));
        label->setText(QString());
        label_2->setText(QCoreApplication::translate("GarbResult", "\346\202\250\350\216\267\345\276\227\344\272\206", nullptr));
        label_3->setText(QCoreApplication::translate("GarbResult", "2000", nullptr));
        label_4->setText(QCoreApplication::translate("GarbResult", "\347\247\257\345\210\206", nullptr));
        label_5->setText(QCoreApplication::translate("GarbResult", "\346\235\245\350\207\252 \347\232\204\347\272\242\345\214\205", nullptr));
        label_6->setText(QCoreApplication::translate("GarbResult", "\346\202\250\350\216\267\345\276\227\344\272\206", nullptr));
        label_7->setText(QString());
    } // retranslateUi

};

namespace Ui {
    class GarbResult: public Ui_GarbResult {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_GARBRESULT_H
