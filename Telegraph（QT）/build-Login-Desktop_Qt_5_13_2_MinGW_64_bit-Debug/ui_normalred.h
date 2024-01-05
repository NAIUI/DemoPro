/********************************************************************************
** Form generated from reading UI file 'normalred.ui'
**
** Created by: Qt User Interface Compiler version 5.13.2
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_NORMALRED_H
#define UI_NORMALRED_H

#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QDialog>
#include <QtWidgets/QDialogButtonBox>
#include <QtWidgets/QLabel>
#include <QtWidgets/QLineEdit>

QT_BEGIN_NAMESPACE

class Ui_NormalRed
{
public:
    QDialogButtonBox *buttonBox;
    QLabel *label;
    QLabel *label_2;
    QLabel *label_3;
    QLabel *label_4;
    QLineEdit *lineEdit;

    void setupUi(QDialog *NormalRed)
    {
        if (NormalRed->objectName().isEmpty())
            NormalRed->setObjectName(QString::fromUtf8("NormalRed"));
        NormalRed->resize(606, 401);
        NormalRed->setStyleSheet(QString::fromUtf8(""));
        buttonBox = new QDialogButtonBox(NormalRed);
        buttonBox->setObjectName(QString::fromUtf8("buttonBox"));
        buttonBox->setGeometry(QRect(190, 320, 341, 32));
        buttonBox->setOrientation(Qt::Horizontal);
        buttonBox->setStandardButtons(QDialogButtonBox::Cancel|QDialogButtonBox::Ok);
        label = new QLabel(NormalRed);
        label->setObjectName(QString::fromUtf8("label"));
        label->setGeometry(QRect(0, -10, 621, 421));
        label->setPixmap(QPixmap(QString::fromUtf8(":/image/bg/redpacknormal.png")));
        label_2 = new QLabel(NormalRed);
        label_2->setObjectName(QString::fromUtf8("label_2"));
        label_2->setGeometry(QRect(171, 177, 111, 20));
        label_3 = new QLabel(NormalRed);
        label_3->setObjectName(QString::fromUtf8("label_3"));
        label_3->setGeometry(QRect(200, 227, 81, 16));
        label_4 = new QLabel(NormalRed);
        label_4->setObjectName(QString::fromUtf8("label_4"));
        label_4->setGeometry(QRect(280, 180, 72, 15));
        lineEdit = new QLineEdit(NormalRed);
        lineEdit->setObjectName(QString::fromUtf8("lineEdit"));
        lineEdit->setGeometry(QRect(280, 217, 113, 30));
        lineEdit->setMinimumSize(QSize(0, 30));
        label->raise();
        buttonBox->raise();
        label_2->raise();
        label_3->raise();
        lineEdit->raise();
        label_2->raise();
        label_3->raise();
        label_4->raise();
        lineEdit->raise();

        retranslateUi(NormalRed);
        QObject::connect(buttonBox, SIGNAL(accepted()), NormalRed, SLOT(accept()));
        QObject::connect(buttonBox, SIGNAL(rejected()), NormalRed, SLOT(reject()));

        QMetaObject::connectSlotsByName(NormalRed);
    } // setupUi

    void retranslateUi(QDialog *NormalRed)
    {
        NormalRed->setWindowTitle(QCoreApplication::translate("NormalRed", "\345\217\221\351\200\201\347\272\242\345\214\205", nullptr));
        label->setText(QString());
        label_2->setText(QCoreApplication::translate("NormalRed", "\346\202\250\345\275\223\345\211\215\347\232\204\347\247\257\345\210\206\357\274\232", nullptr));
        label_3->setText(QCoreApplication::translate("NormalRed", "\345\217\221\351\200\201\351\207\221\351\242\235\357\274\232", nullptr));
        label_4->setText(QCoreApplication::translate("NormalRed", "TextLabel", nullptr));
    } // retranslateUi

};

namespace Ui {
    class NormalRed: public Ui_NormalRed {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_NORMALRED_H
