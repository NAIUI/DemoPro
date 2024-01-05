/********************************************************************************
** Form generated from reading UI file 'creatgroup.ui'
**
** Created by: Qt User Interface Compiler version 5.13.2
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_CREATGROUP_H
#define UI_CREATGROUP_H

#include <QtCore/QVariant>
#include <QtGui/QIcon>
#include <QtWidgets/QApplication>
#include <QtWidgets/QDialog>
#include <QtWidgets/QDialogButtonBox>
#include <QtWidgets/QGroupBox>
#include <QtWidgets/QHBoxLayout>
#include <QtWidgets/QLineEdit>
#include <QtWidgets/QListWidget>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QSpacerItem>
#include <QtWidgets/QVBoxLayout>

QT_BEGIN_NAMESPACE

class Ui_CreatGroup
{
public:
    QVBoxLayout *verticalLayout;
    QGroupBox *groupBox;
    QLineEdit *lineEdit;
    QGroupBox *groupBox_2;
    QHBoxLayout *horizontalLayout;
    QListWidget *listWidget;
    QVBoxLayout *verticalLayout_2;
    QSpacerItem *verticalSpacer;
    QPushButton *pushButton;
    QPushButton *pushButton_2;
    QSpacerItem *verticalSpacer_2;
    QListWidget *listWidget_2;
    QDialogButtonBox *buttonBox;

    void setupUi(QDialog *CreatGroup)
    {
        if (CreatGroup->objectName().isEmpty())
            CreatGroup->setObjectName(QString::fromUtf8("CreatGroup"));
        CreatGroup->resize(400, 423);
        QIcon icon;
        icon.addFile(QString::fromUtf8(":/image/ico"), QSize(), QIcon::Normal, QIcon::Off);
        CreatGroup->setWindowIcon(icon);
        verticalLayout = new QVBoxLayout(CreatGroup);
        verticalLayout->setObjectName(QString::fromUtf8("verticalLayout"));
        groupBox = new QGroupBox(CreatGroup);
        groupBox->setObjectName(QString::fromUtf8("groupBox"));
        QSizePolicy sizePolicy(QSizePolicy::Preferred, QSizePolicy::Fixed);
        sizePolicy.setHorizontalStretch(0);
        sizePolicy.setVerticalStretch(0);
        sizePolicy.setHeightForWidth(groupBox->sizePolicy().hasHeightForWidth());
        groupBox->setSizePolicy(sizePolicy);
        groupBox->setMinimumSize(QSize(0, 80));
        lineEdit = new QLineEdit(groupBox);
        lineEdit->setObjectName(QString::fromUtf8("lineEdit"));
        lineEdit->setGeometry(QRect(40, 30, 281, 25));
        lineEdit->setMinimumSize(QSize(0, 25));

        verticalLayout->addWidget(groupBox);

        groupBox_2 = new QGroupBox(CreatGroup);
        groupBox_2->setObjectName(QString::fromUtf8("groupBox_2"));
        horizontalLayout = new QHBoxLayout(groupBox_2);
        horizontalLayout->setObjectName(QString::fromUtf8("horizontalLayout"));
        listWidget = new QListWidget(groupBox_2);
        listWidget->setObjectName(QString::fromUtf8("listWidget"));
        listWidget->setModelColumn(0);

        horizontalLayout->addWidget(listWidget);

        verticalLayout_2 = new QVBoxLayout();
        verticalLayout_2->setObjectName(QString::fromUtf8("verticalLayout_2"));
        verticalSpacer = new QSpacerItem(20, 40, QSizePolicy::Minimum, QSizePolicy::Expanding);

        verticalLayout_2->addItem(verticalSpacer);

        pushButton = new QPushButton(groupBox_2);
        pushButton->setObjectName(QString::fromUtf8("pushButton"));

        verticalLayout_2->addWidget(pushButton);

        pushButton_2 = new QPushButton(groupBox_2);
        pushButton_2->setObjectName(QString::fromUtf8("pushButton_2"));

        verticalLayout_2->addWidget(pushButton_2);

        verticalSpacer_2 = new QSpacerItem(20, 40, QSizePolicy::Minimum, QSizePolicy::Expanding);

        verticalLayout_2->addItem(verticalSpacer_2);


        horizontalLayout->addLayout(verticalLayout_2);

        listWidget_2 = new QListWidget(groupBox_2);
        listWidget_2->setObjectName(QString::fromUtf8("listWidget_2"));

        horizontalLayout->addWidget(listWidget_2);


        verticalLayout->addWidget(groupBox_2);

        buttonBox = new QDialogButtonBox(CreatGroup);
        buttonBox->setObjectName(QString::fromUtf8("buttonBox"));
        buttonBox->setOrientation(Qt::Horizontal);
        buttonBox->setStandardButtons(QDialogButtonBox::Cancel|QDialogButtonBox::Ok);

        verticalLayout->addWidget(buttonBox);


        retranslateUi(CreatGroup);
        QObject::connect(buttonBox, SIGNAL(accepted()), CreatGroup, SLOT(accept()));
        QObject::connect(buttonBox, SIGNAL(rejected()), CreatGroup, SLOT(reject()));

        QMetaObject::connectSlotsByName(CreatGroup);
    } // setupUi

    void retranslateUi(QDialog *CreatGroup)
    {
        CreatGroup->setWindowTitle(QCoreApplication::translate("CreatGroup", "\345\210\233\345\273\272\347\276\244\350\201\212", nullptr));
        groupBox->setTitle(QCoreApplication::translate("CreatGroup", "\350\276\223\345\205\245\347\276\244\350\201\212\345\220\215\347\247\260", nullptr));
        groupBox_2->setTitle(QCoreApplication::translate("CreatGroup", "\351\200\211\346\213\251\346\210\220\345\221\230", nullptr));
        pushButton->setText(QCoreApplication::translate("CreatGroup", ">>", nullptr));
        pushButton_2->setText(QCoreApplication::translate("CreatGroup", "<<", nullptr));
    } // retranslateUi

};

namespace Ui {
    class CreatGroup: public Ui_CreatGroup {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_CREATGROUP_H
