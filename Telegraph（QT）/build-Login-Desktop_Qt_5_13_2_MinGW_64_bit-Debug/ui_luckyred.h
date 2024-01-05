/********************************************************************************
** Form generated from reading UI file 'luckyred.ui'
**
** Created by: Qt User Interface Compiler version 5.13.2
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_LUCKYRED_H
#define UI_LUCKYRED_H

#include <QtCore/QVariant>
#include <QtGui/QIcon>
#include <QtWidgets/QApplication>
#include <QtWidgets/QDialog>
#include <QtWidgets/QDialogButtonBox>
#include <QtWidgets/QLabel>
#include <QtWidgets/QLineEdit>

QT_BEGIN_NAMESPACE

class Ui_LuckyRed
{
public:
    QDialogButtonBox *buttonBox;
    QLabel *label;
    QLabel *label_3;
    QLabel *label_4;
    QLineEdit *lineEdit;
    QLabel *label_5;
    QLabel *label_2;
    QLineEdit *lineEdit_2;

    void setupUi(QDialog *LuckyRed)
    {
        if (LuckyRed->objectName().isEmpty())
            LuckyRed->setObjectName(QString::fromUtf8("LuckyRed"));
        LuckyRed->resize(598, 407);
        QIcon icon;
        icon.addFile(QString::fromUtf8(":/image/ico"), QSize(), QIcon::Normal, QIcon::Off);
        LuckyRed->setWindowIcon(icon);
        buttonBox = new QDialogButtonBox(LuckyRed);
        buttonBox->setObjectName(QString::fromUtf8("buttonBox"));
        buttonBox->setGeometry(QRect(190, 320, 341, 32));
        buttonBox->setOrientation(Qt::Horizontal);
        buttonBox->setStandardButtons(QDialogButtonBox::Cancel|QDialogButtonBox::Ok);
        label = new QLabel(LuckyRed);
        label->setObjectName(QString::fromUtf8("label"));
        label->setGeometry(QRect(0, -1, 601, 411));
        label->setPixmap(QPixmap(QString::fromUtf8(":/image/bg/blue.png")));
        label_3 = new QLabel(LuckyRed);
        label_3->setObjectName(QString::fromUtf8("label_3"));
        label_3->setGeometry(QRect(161, 161, 105, 16));
        label_4 = new QLabel(LuckyRed);
        label_4->setObjectName(QString::fromUtf8("label_4"));
        label_4->setGeometry(QRect(173, 201, 90, 16));
        lineEdit = new QLineEdit(LuckyRed);
        lineEdit->setObjectName(QString::fromUtf8("lineEdit"));
        lineEdit->setGeometry(QRect(273, 195, 156, 30));
        lineEdit->setMinimumSize(QSize(0, 30));
        label_5 = new QLabel(LuckyRed);
        label_5->setObjectName(QString::fromUtf8("label_5"));
        label_5->setGeometry(QRect(273, 161, 72, 16));
        label_2 = new QLabel(LuckyRed);
        label_2->setObjectName(QString::fromUtf8("label_2"));
        label_2->setGeometry(QRect(186, 241, 111, 16));
        lineEdit_2 = new QLineEdit(LuckyRed);
        lineEdit_2->setObjectName(QString::fromUtf8("lineEdit_2"));
        lineEdit_2->setGeometry(QRect(273, 234, 156, 30));
        lineEdit_2->setMinimumSize(QSize(0, 30));
        label->raise();
        buttonBox->raise();
        label_4->raise();
        label_5->raise();
        label_3->raise();
        label_2->raise();
        lineEdit->raise();
        lineEdit_2->raise();

        retranslateUi(LuckyRed);
        QObject::connect(buttonBox, SIGNAL(accepted()), LuckyRed, SLOT(accept()));
        QObject::connect(buttonBox, SIGNAL(rejected()), LuckyRed, SLOT(reject()));

        QMetaObject::connectSlotsByName(LuckyRed);
    } // setupUi

    void retranslateUi(QDialog *LuckyRed)
    {
        LuckyRed->setWindowTitle(QCoreApplication::translate("LuckyRed", "\346\213\274\346\211\213\346\260\224\347\272\242\345\214\205", nullptr));
        label->setText(QString());
        label_3->setText(QCoreApplication::translate("LuckyRed", "\346\202\250\345\275\223\345\211\215\347\232\204\347\247\257\345\210\206\357\274\232", nullptr));
        label_4->setText(QCoreApplication::translate("LuckyRed", "\345\217\221\351\200\201\346\200\273\351\207\221\351\242\235\357\274\232", nullptr));
        label_5->setText(QCoreApplication::translate("LuckyRed", "TextLabel", nullptr));
        label_2->setText(QCoreApplication::translate("LuckyRed", "\347\272\242\345\214\205\344\270\252\346\225\260:", nullptr));
    } // retranslateUi

};

namespace Ui {
    class LuckyRed: public Ui_LuckyRed {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_LUCKYRED_H
