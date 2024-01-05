/********************************************************************************
** Form generated from reading UI file 'purchase.ui'
**
** Created by: Qt User Interface Compiler version 5.13.2
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_PURCHASE_H
#define UI_PURCHASE_H

#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QGroupBox>
#include <QtWidgets/QLabel>
#include <QtWidgets/QLineEdit>
#include <QtWidgets/QVBoxLayout>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_Purchase
{
public:
    QVBoxLayout *verticalLayout;
    QGroupBox *groupBox;
    QLabel *label;
    QLineEdit *lineEdit;
    QLabel *label_2;
    QLabel *label_3;
    QGroupBox *groupBox_2;
    QLabel *label_4;
    QLabel *label_5;
    QGroupBox *groupBox_3;
    QLabel *label_6;

    void setupUi(QWidget *Purchase)
    {
        if (Purchase->objectName().isEmpty())
            Purchase->setObjectName(QString::fromUtf8("Purchase"));
        Purchase->resize(309, 548);
        verticalLayout = new QVBoxLayout(Purchase);
        verticalLayout->setObjectName(QString::fromUtf8("verticalLayout"));
        groupBox = new QGroupBox(Purchase);
        groupBox->setObjectName(QString::fromUtf8("groupBox"));
        groupBox->setMaximumSize(QSize(16777215, 100));
        label = new QLabel(groupBox);
        label->setObjectName(QString::fromUtf8("label"));
        label->setGeometry(QRect(30, 30, 72, 15));
        lineEdit = new QLineEdit(groupBox);
        lineEdit->setObjectName(QString::fromUtf8("lineEdit"));
        lineEdit->setGeometry(QRect(100, 28, 113, 21));
        lineEdit->setReadOnly(true);
        label_2 = new QLabel(groupBox);
        label_2->setObjectName(QString::fromUtf8("label_2"));
        label_2->setGeometry(QRect(30, 67, 72, 15));
        label_3 = new QLabel(groupBox);
        label_3->setObjectName(QString::fromUtf8("label_3"));
        label_3->setGeometry(QRect(103, 65, 81, 21));
        QFont font;
        font.setFamily(QString::fromUtf8("\345\276\256\350\275\257\351\233\205\351\273\221"));
        font.setPointSize(12);
        label_3->setFont(font);
        label_3->setStyleSheet(QString::fromUtf8("color: rgb(255, 85, 0);"));

        verticalLayout->addWidget(groupBox);

        groupBox_2 = new QGroupBox(Purchase);
        groupBox_2->setObjectName(QString::fromUtf8("groupBox_2"));
        QSizePolicy sizePolicy(QSizePolicy::Preferred, QSizePolicy::Fixed);
        sizePolicy.setHorizontalStretch(0);
        sizePolicy.setVerticalStretch(0);
        sizePolicy.setHeightForWidth(groupBox_2->sizePolicy().hasHeightForWidth());
        groupBox_2->setSizePolicy(sizePolicy);
        groupBox_2->setMinimumSize(QSize(240, 300));
        groupBox_2->setMaximumSize(QSize(16777215, 300));
        label_4 = new QLabel(groupBox_2);
        label_4->setObjectName(QString::fromUtf8("label_4"));
        label_4->setGeometry(QRect(110, 110, 72, 15));
        label_5 = new QLabel(groupBox_2);
        label_5->setObjectName(QString::fromUtf8("label_5"));
        label_5->setGeometry(QRect(20, 30, 240, 240));
        QSizePolicy sizePolicy1(QSizePolicy::Fixed, QSizePolicy::Fixed);
        sizePolicy1.setHorizontalStretch(0);
        sizePolicy1.setVerticalStretch(0);
        sizePolicy1.setHeightForWidth(label_5->sizePolicy().hasHeightForWidth());
        label_5->setSizePolicy(sizePolicy1);
        label_5->setMinimumSize(QSize(240, 240));
        label_5->setMaximumSize(QSize(240, 240));
        label_5->setStyleSheet(QString::fromUtf8(""));

        verticalLayout->addWidget(groupBox_2);

        groupBox_3 = new QGroupBox(Purchase);
        groupBox_3->setObjectName(QString::fromUtf8("groupBox_3"));
        groupBox_3->setMinimumSize(QSize(0, 8));
        groupBox_3->setMaximumSize(QSize(16777215, 80));
        label_6 = new QLabel(groupBox_3);
        label_6->setObjectName(QString::fromUtf8("label_6"));
        label_6->setGeometry(QRect(100, 30, 111, 31));
        QFont font1;
        font1.setFamily(QString::fromUtf8("\345\276\256\350\275\257\351\233\205\351\273\221"));
        font1.setPointSize(14);
        label_6->setFont(font1);
        label_6->setStyleSheet(QString::fromUtf8(""));

        verticalLayout->addWidget(groupBox_3);


        retranslateUi(Purchase);

        QMetaObject::connectSlotsByName(Purchase);
    } // setupUi

    void retranslateUi(QWidget *Purchase)
    {
        Purchase->setWindowTitle(QCoreApplication::translate("Purchase", "Form", nullptr));
        groupBox->setTitle(QCoreApplication::translate("Purchase", "\350\256\242\345\215\225\344\277\241\346\201\257", nullptr));
        label->setText(QCoreApplication::translate("Purchase", "\345\205\205\345\200\274\347\247\257\345\210\206\357\274\232", nullptr));
        label_2->setText(QCoreApplication::translate("Purchase", "\345\272\224\344\273\230\351\207\221\351\242\235\357\274\232", nullptr));
        label_3->setText(QCoreApplication::translate("Purchase", "\357\277\24519.0", nullptr));
        groupBox_2->setTitle(QCoreApplication::translate("Purchase", "\346\224\257\344\273\230\344\272\214\347\273\264\347\240\201", nullptr));
        label_4->setText(QCoreApplication::translate("Purchase", "\345\212\240\350\275\275\344\270\255...", nullptr));
        label_5->setText(QString());
        groupBox_3->setTitle(QCoreApplication::translate("Purchase", "\346\224\257\344\273\230\347\212\266\346\200\201", nullptr));
        label_6->setText(QCoreApplication::translate("Purchase", "\346\234\252\346\224\257\344\273\230", nullptr));
    } // retranslateUi

};

namespace Ui {
    class Purchase: public Ui_Purchase {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_PURCHASE_H
