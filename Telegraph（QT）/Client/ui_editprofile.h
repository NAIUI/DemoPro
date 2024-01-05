/********************************************************************************
** Form generated from reading UI file 'editprofile.ui'
**
** Created by: Qt User Interface Compiler version 5.13.2
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_EDITPROFILE_H
#define UI_EDITPROFILE_H

#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QDialog>
#include <QtWidgets/QDialogButtonBox>
#include <QtWidgets/QFormLayout>
#include <QtWidgets/QLabel>
#include <QtWidgets/QLineEdit>
#include <QtWidgets/QVBoxLayout>

QT_BEGIN_NAMESPACE

class Ui_EditProfile
{
public:
    QVBoxLayout *verticalLayout;
    QFormLayout *formLayout;
    QLabel *label;
    QLineEdit *lineEdit;
    QLabel *label_2;
    QLineEdit *lineEdit_2;
    QLabel *label_3;
    QLabel *label_4;
    QDialogButtonBox *buttonBox;

    void setupUi(QDialog *EditProfile)
    {
        if (EditProfile->objectName().isEmpty())
            EditProfile->setObjectName(QString::fromUtf8("EditProfile"));
        EditProfile->resize(400, 160);
        verticalLayout = new QVBoxLayout(EditProfile);
        verticalLayout->setObjectName(QString::fromUtf8("verticalLayout"));
        formLayout = new QFormLayout();
        formLayout->setObjectName(QString::fromUtf8("formLayout"));
        label = new QLabel(EditProfile);
        label->setObjectName(QString::fromUtf8("label"));

        formLayout->setWidget(0, QFormLayout::LabelRole, label);

        lineEdit = new QLineEdit(EditProfile);
        lineEdit->setObjectName(QString::fromUtf8("lineEdit"));
        lineEdit->setMinimumSize(QSize(0, 25));

        formLayout->setWidget(0, QFormLayout::FieldRole, lineEdit);

        label_2 = new QLabel(EditProfile);
        label_2->setObjectName(QString::fromUtf8("label_2"));

        formLayout->setWidget(1, QFormLayout::LabelRole, label_2);

        lineEdit_2 = new QLineEdit(EditProfile);
        lineEdit_2->setObjectName(QString::fromUtf8("lineEdit_2"));
        lineEdit_2->setMinimumSize(QSize(0, 25));
        lineEdit_2->setEchoMode(QLineEdit::Password);

        formLayout->setWidget(1, QFormLayout::FieldRole, lineEdit_2);


        verticalLayout->addLayout(formLayout);

        label_3 = new QLabel(EditProfile);
        label_3->setObjectName(QString::fromUtf8("label_3"));

        verticalLayout->addWidget(label_3);

        label_4 = new QLabel(EditProfile);
        label_4->setObjectName(QString::fromUtf8("label_4"));

        verticalLayout->addWidget(label_4);

        buttonBox = new QDialogButtonBox(EditProfile);
        buttonBox->setObjectName(QString::fromUtf8("buttonBox"));
        buttonBox->setOrientation(Qt::Horizontal);
        buttonBox->setStandardButtons(QDialogButtonBox::Cancel|QDialogButtonBox::Ok);

        verticalLayout->addWidget(buttonBox);


        retranslateUi(EditProfile);
        QObject::connect(buttonBox, SIGNAL(accepted()), EditProfile, SLOT(accept()));
        QObject::connect(buttonBox, SIGNAL(rejected()), EditProfile, SLOT(reject()));

        QMetaObject::connectSlotsByName(EditProfile);
    } // setupUi

    void retranslateUi(QDialog *EditProfile)
    {
        EditProfile->setWindowTitle(QCoreApplication::translate("EditProfile", "\344\277\256\346\224\271\344\277\241\346\201\257", nullptr));
        label->setText(QCoreApplication::translate("EditProfile", "\347\224\250\346\210\267\345\220\215\357\274\232", nullptr));
        label_2->setText(QCoreApplication::translate("EditProfile", "\345\257\206\347\240\201:", nullptr));
        lineEdit_2->setText(QString());
        label_3->setText(QCoreApplication::translate("EditProfile", "\346\263\250\346\204\217\357\274\232\345\257\206\347\240\201\347\225\231\347\251\272\350\241\250\347\244\272\344\270\215\344\277\256\346\224\271", nullptr));
        label_4->setText(QCoreApplication::translate("EditProfile", "\344\277\256\346\224\271\344\277\241\346\201\257\345\220\216\351\234\200\350\246\201\351\207\215\346\226\260\347\231\273\345\275\225", nullptr));
    } // retranslateUi

};

namespace Ui {
    class EditProfile: public Ui_EditProfile {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_EDITPROFILE_H
