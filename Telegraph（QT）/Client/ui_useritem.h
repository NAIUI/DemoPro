/********************************************************************************
** Form generated from reading UI file 'useritem.ui'
**
** Created by: Qt User Interface Compiler version 5.13.2
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_USERITEM_H
#define UI_USERITEM_H

#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QLabel>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_UserItem
{
public:
    QLabel *label;
    QLabel *label_2;
    QLabel *label_3;
    QLabel *label_4;

    void setupUi(QWidget *UserItem)
    {
        if (UserItem->objectName().isEmpty())
            UserItem->setObjectName(QString::fromUtf8("UserItem"));
        UserItem->resize(405, 92);
        label = new QLabel(UserItem);
        label->setObjectName(QString::fromUtf8("label"));
        label->setGeometry(QRect(10, 10, 64, 64));
        QSizePolicy sizePolicy(QSizePolicy::Fixed, QSizePolicy::Fixed);
        sizePolicy.setHorizontalStretch(0);
        sizePolicy.setVerticalStretch(0);
        sizePolicy.setHeightForWidth(label->sizePolicy().hasHeightForWidth());
        label->setSizePolicy(sizePolicy);
        label->setMaximumSize(QSize(64, 64));
        label->setStyleSheet(QString::fromUtf8(""));
        label_2 = new QLabel(UserItem);
        label_2->setObjectName(QString::fromUtf8("label_2"));
        label_2->setGeometry(QRect(90, 20, 181, 21));
        label_3 = new QLabel(UserItem);
        label_3->setObjectName(QString::fromUtf8("label_3"));
        label_3->setGeometry(QRect(90, 40, 221, 16));
        label_3->setStyleSheet(QString::fromUtf8("color: rgb(193, 193, 193);"));
        label_4 = new QLabel(UserItem);
        label_4->setObjectName(QString::fromUtf8("label_4"));
        label_4->setEnabled(true);
        label_4->setGeometry(QRect(60, 10, 20, 20));
        sizePolicy.setHeightForWidth(label_4->sizePolicy().hasHeightForWidth());
        label_4->setSizePolicy(sizePolicy);
        label_4->setMinimumSize(QSize(20, 20));
        label_4->setMaximumSize(QSize(500, 20));
        label_4->setStyleSheet(QString::fromUtf8("border-radius:10px;\n"
"background-color: rgb(255, 0, 0);\n"
"height:20px;\n"
"color: rgb(255, 255, 255);\n"
"padding:2px;"));

        retranslateUi(UserItem);

        QMetaObject::connectSlotsByName(UserItem);
    } // setupUi

    void retranslateUi(QWidget *UserItem)
    {
        UserItem->setWindowTitle(QCoreApplication::translate("UserItem", "Form", nullptr));
        label->setText(QString());
        label_2->setText(QString());
        label_3->setText(QString());
        label_4->setText(QCoreApplication::translate("UserItem", "1", nullptr));
    } // retranslateUi

};

namespace Ui {
    class UserItem: public Ui_UserItem {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_USERITEM_H
