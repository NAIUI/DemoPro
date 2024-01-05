/********************************************************************************
** Form generated from reading UI file 'stylechange.ui'
**
** Created by: Qt User Interface Compiler version 5.13.2
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_STYLECHANGE_H
#define UI_STYLECHANGE_H

#include <QtCore/QVariant>
#include <QtGui/QIcon>
#include <QtWidgets/QApplication>
#include <QtWidgets/QDialog>
#include <QtWidgets/QDialogButtonBox>
#include <QtWidgets/QFormLayout>
#include <QtWidgets/QGroupBox>
#include <QtWidgets/QHBoxLayout>
#include <QtWidgets/QLabel>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QSpacerItem>
#include <QtWidgets/QTabWidget>
#include <QtWidgets/QVBoxLayout>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_StyleChange
{
public:
    QVBoxLayout *verticalLayout;
    QTabWidget *tabWidget;
    QWidget *tab;
    QVBoxLayout *verticalLayout_2;
    QGroupBox *groupBox;
    QFormLayout *formLayout;
    QLabel *label;
    QHBoxLayout *horizontalLayout;
    QLabel *selfback;
    QPushButton *pushButton;
    QLabel *label_2;
    QHBoxLayout *horizontalLayout_2;
    QLabel *selftext;
    QPushButton *pushButton_2;
    QGroupBox *groupBox_2;
    QFormLayout *formLayout_2;
    QLabel *label_3;
    QHBoxLayout *horizontalLayout_3;
    QLabel *youback;
    QPushButton *pushButton_3;
    QLabel *label_4;
    QHBoxLayout *horizontalLayout_4;
    QLabel *youtext;
    QPushButton *pushButton_4;
    QWidget *tab_2;
    QVBoxLayout *verticalLayout_4;
    QGroupBox *groupBox_3;
    QVBoxLayout *verticalLayout_3;
    QHBoxLayout *horizontalLayout_5;
    QPushButton *pushButton_5;
    QSpacerItem *horizontalSpacer;
    QLabel *label_5;
    QGroupBox *groupBox_4;
    QVBoxLayout *verticalLayout_5;
    QSpacerItem *verticalSpacer;
    QHBoxLayout *horizontalLayout_6;
    QLabel *back;
    QPushButton *pushButton_6;
    QSpacerItem *verticalSpacer_2;
    QWidget *tab_3;
    QDialogButtonBox *buttonBox;

    void setupUi(QDialog *StyleChange)
    {
        if (StyleChange->objectName().isEmpty())
            StyleChange->setObjectName(QString::fromUtf8("StyleChange"));
        StyleChange->resize(410, 391);
        QIcon icon;
        icon.addFile(QString::fromUtf8(":/image/ico"), QSize(), QIcon::Normal, QIcon::Off);
        StyleChange->setWindowIcon(icon);
        verticalLayout = new QVBoxLayout(StyleChange);
        verticalLayout->setObjectName(QString::fromUtf8("verticalLayout"));
        tabWidget = new QTabWidget(StyleChange);
        tabWidget->setObjectName(QString::fromUtf8("tabWidget"));
        tab = new QWidget();
        tab->setObjectName(QString::fromUtf8("tab"));
        verticalLayout_2 = new QVBoxLayout(tab);
        verticalLayout_2->setObjectName(QString::fromUtf8("verticalLayout_2"));
        groupBox = new QGroupBox(tab);
        groupBox->setObjectName(QString::fromUtf8("groupBox"));
        formLayout = new QFormLayout(groupBox);
        formLayout->setObjectName(QString::fromUtf8("formLayout"));
        label = new QLabel(groupBox);
        label->setObjectName(QString::fromUtf8("label"));

        formLayout->setWidget(0, QFormLayout::LabelRole, label);

        horizontalLayout = new QHBoxLayout();
        horizontalLayout->setObjectName(QString::fromUtf8("horizontalLayout"));
        selfback = new QLabel(groupBox);
        selfback->setObjectName(QString::fromUtf8("selfback"));
        QSizePolicy sizePolicy(QSizePolicy::Fixed, QSizePolicy::Preferred);
        sizePolicy.setHorizontalStretch(0);
        sizePolicy.setVerticalStretch(0);
        sizePolicy.setHeightForWidth(selfback->sizePolicy().hasHeightForWidth());
        selfback->setSizePolicy(sizePolicy);
        selfback->setMinimumSize(QSize(50, 0));
        selfback->setStyleSheet(QString::fromUtf8("background-color:#eceff1;"));
        selfback->setFrameShape(QFrame::Box);

        horizontalLayout->addWidget(selfback);

        pushButton = new QPushButton(groupBox);
        pushButton->setObjectName(QString::fromUtf8("pushButton"));
        pushButton->setStyleSheet(QString::fromUtf8(""));

        horizontalLayout->addWidget(pushButton);


        formLayout->setLayout(0, QFormLayout::FieldRole, horizontalLayout);

        label_2 = new QLabel(groupBox);
        label_2->setObjectName(QString::fromUtf8("label_2"));

        formLayout->setWidget(1, QFormLayout::LabelRole, label_2);

        horizontalLayout_2 = new QHBoxLayout();
        horizontalLayout_2->setObjectName(QString::fromUtf8("horizontalLayout_2"));
        selftext = new QLabel(groupBox);
        selftext->setObjectName(QString::fromUtf8("selftext"));
        sizePolicy.setHeightForWidth(selftext->sizePolicy().hasHeightForWidth());
        selftext->setSizePolicy(sizePolicy);
        selftext->setMinimumSize(QSize(50, 0));
        selftext->setStyleSheet(QString::fromUtf8("background-color: #1a1a1a;"));
        selftext->setFrameShape(QFrame::Box);

        horizontalLayout_2->addWidget(selftext);

        pushButton_2 = new QPushButton(groupBox);
        pushButton_2->setObjectName(QString::fromUtf8("pushButton_2"));
        pushButton_2->setStyleSheet(QString::fromUtf8(""));

        horizontalLayout_2->addWidget(pushButton_2);


        formLayout->setLayout(1, QFormLayout::FieldRole, horizontalLayout_2);


        verticalLayout_2->addWidget(groupBox);

        groupBox_2 = new QGroupBox(tab);
        groupBox_2->setObjectName(QString::fromUtf8("groupBox_2"));
        formLayout_2 = new QFormLayout(groupBox_2);
        formLayout_2->setObjectName(QString::fromUtf8("formLayout_2"));
        label_3 = new QLabel(groupBox_2);
        label_3->setObjectName(QString::fromUtf8("label_3"));

        formLayout_2->setWidget(0, QFormLayout::LabelRole, label_3);

        horizontalLayout_3 = new QHBoxLayout();
        horizontalLayout_3->setObjectName(QString::fromUtf8("horizontalLayout_3"));
        youback = new QLabel(groupBox_2);
        youback->setObjectName(QString::fromUtf8("youback"));
        sizePolicy.setHeightForWidth(youback->sizePolicy().hasHeightForWidth());
        youback->setSizePolicy(sizePolicy);
        youback->setMinimumSize(QSize(50, 0));
        youback->setStyleSheet(QString::fromUtf8("background-color:#00b0ff;"));
        youback->setFrameShape(QFrame::Box);

        horizontalLayout_3->addWidget(youback);

        pushButton_3 = new QPushButton(groupBox_2);
        pushButton_3->setObjectName(QString::fromUtf8("pushButton_3"));
        pushButton_3->setStyleSheet(QString::fromUtf8(""));

        horizontalLayout_3->addWidget(pushButton_3);


        formLayout_2->setLayout(0, QFormLayout::FieldRole, horizontalLayout_3);

        label_4 = new QLabel(groupBox_2);
        label_4->setObjectName(QString::fromUtf8("label_4"));

        formLayout_2->setWidget(1, QFormLayout::LabelRole, label_4);

        horizontalLayout_4 = new QHBoxLayout();
        horizontalLayout_4->setObjectName(QString::fromUtf8("horizontalLayout_4"));
        youtext = new QLabel(groupBox_2);
        youtext->setObjectName(QString::fromUtf8("youtext"));
        sizePolicy.setHeightForWidth(youtext->sizePolicy().hasHeightForWidth());
        youtext->setSizePolicy(sizePolicy);
        youtext->setMinimumSize(QSize(50, 0));
        youtext->setStyleSheet(QString::fromUtf8("background-color:#fff;"));
        youtext->setFrameShape(QFrame::Box);

        horizontalLayout_4->addWidget(youtext);

        pushButton_4 = new QPushButton(groupBox_2);
        pushButton_4->setObjectName(QString::fromUtf8("pushButton_4"));
        pushButton_4->setStyleSheet(QString::fromUtf8(""));

        horizontalLayout_4->addWidget(pushButton_4);


        formLayout_2->setLayout(1, QFormLayout::FieldRole, horizontalLayout_4);


        verticalLayout_2->addWidget(groupBox_2);

        tabWidget->addTab(tab, QString());
        tab_2 = new QWidget();
        tab_2->setObjectName(QString::fromUtf8("tab_2"));
        verticalLayout_4 = new QVBoxLayout(tab_2);
        verticalLayout_4->setObjectName(QString::fromUtf8("verticalLayout_4"));
        groupBox_3 = new QGroupBox(tab_2);
        groupBox_3->setObjectName(QString::fromUtf8("groupBox_3"));
        verticalLayout_3 = new QVBoxLayout(groupBox_3);
        verticalLayout_3->setObjectName(QString::fromUtf8("verticalLayout_3"));
        horizontalLayout_5 = new QHBoxLayout();
        horizontalLayout_5->setObjectName(QString::fromUtf8("horizontalLayout_5"));
        pushButton_5 = new QPushButton(groupBox_3);
        pushButton_5->setObjectName(QString::fromUtf8("pushButton_5"));

        horizontalLayout_5->addWidget(pushButton_5);

        horizontalSpacer = new QSpacerItem(40, 20, QSizePolicy::Expanding, QSizePolicy::Minimum);

        horizontalLayout_5->addItem(horizontalSpacer);


        verticalLayout_3->addLayout(horizontalLayout_5);

        label_5 = new QLabel(groupBox_3);
        label_5->setObjectName(QString::fromUtf8("label_5"));
        sizePolicy.setHeightForWidth(label_5->sizePolicy().hasHeightForWidth());
        label_5->setSizePolicy(sizePolicy);
        label_5->setMaximumSize(QSize(360, 16777215));

        verticalLayout_3->addWidget(label_5);


        verticalLayout_4->addWidget(groupBox_3);

        groupBox_4 = new QGroupBox(tab_2);
        groupBox_4->setObjectName(QString::fromUtf8("groupBox_4"));
        verticalLayout_5 = new QVBoxLayout(groupBox_4);
        verticalLayout_5->setObjectName(QString::fromUtf8("verticalLayout_5"));
        verticalSpacer = new QSpacerItem(20, 40, QSizePolicy::Minimum, QSizePolicy::Expanding);

        verticalLayout_5->addItem(verticalSpacer);

        horizontalLayout_6 = new QHBoxLayout();
        horizontalLayout_6->setObjectName(QString::fromUtf8("horizontalLayout_6"));
        back = new QLabel(groupBox_4);
        back->setObjectName(QString::fromUtf8("back"));
        sizePolicy.setHeightForWidth(back->sizePolicy().hasHeightForWidth());
        back->setSizePolicy(sizePolicy);
        back->setMinimumSize(QSize(50, 0));
        back->setStyleSheet(QString::fromUtf8("background-color:#eceff1;"));
        back->setFrameShape(QFrame::Box);

        horizontalLayout_6->addWidget(back);

        pushButton_6 = new QPushButton(groupBox_4);
        pushButton_6->setObjectName(QString::fromUtf8("pushButton_6"));
        pushButton_6->setStyleSheet(QString::fromUtf8(""));

        horizontalLayout_6->addWidget(pushButton_6);


        verticalLayout_5->addLayout(horizontalLayout_6);

        verticalSpacer_2 = new QSpacerItem(20, 40, QSizePolicy::Minimum, QSizePolicy::Expanding);

        verticalLayout_5->addItem(verticalSpacer_2);


        verticalLayout_4->addWidget(groupBox_4);

        tabWidget->addTab(tab_2, QString());
        tab_3 = new QWidget();
        tab_3->setObjectName(QString::fromUtf8("tab_3"));
        tabWidget->addTab(tab_3, QString());

        verticalLayout->addWidget(tabWidget);

        buttonBox = new QDialogButtonBox(StyleChange);
        buttonBox->setObjectName(QString::fromUtf8("buttonBox"));
        buttonBox->setOrientation(Qt::Horizontal);
        buttonBox->setStandardButtons(QDialogButtonBox::Cancel|QDialogButtonBox::Ok);

        verticalLayout->addWidget(buttonBox);


        retranslateUi(StyleChange);
        QObject::connect(buttonBox, SIGNAL(accepted()), StyleChange, SLOT(accept()));
        QObject::connect(buttonBox, SIGNAL(rejected()), StyleChange, SLOT(reject()));

        tabWidget->setCurrentIndex(1);


        QMetaObject::connectSlotsByName(StyleChange);
    } // setupUi

    void retranslateUi(QDialog *StyleChange)
    {
        StyleChange->setWindowTitle(QCoreApplication::translate("StyleChange", "\344\270\252\346\200\247\345\214\226", nullptr));
        groupBox->setTitle(QCoreApplication::translate("StyleChange", "\350\207\252\345\267\261", nullptr));
        label->setText(QCoreApplication::translate("StyleChange", "\346\260\224\346\263\241\350\203\214\346\231\257\350\211\262\357\274\232", nullptr));
        selfback->setText(QString());
        pushButton->setText(QCoreApplication::translate("StyleChange", "\351\200\211\346\213\251\351\242\234\350\211\262", nullptr));
        label_2->setText(QCoreApplication::translate("StyleChange", "\345\255\227\344\275\223\351\242\234\350\211\262\357\274\232", nullptr));
        selftext->setText(QString());
        pushButton_2->setText(QCoreApplication::translate("StyleChange", "\351\200\211\346\213\251\351\242\234\350\211\262", nullptr));
        groupBox_2->setTitle(QCoreApplication::translate("StyleChange", "\345\257\271\346\226\271", nullptr));
        label_3->setText(QCoreApplication::translate("StyleChange", "\346\260\224\346\263\241\350\203\214\346\231\257\350\211\262\357\274\232", nullptr));
        youback->setText(QString());
        pushButton_3->setText(QCoreApplication::translate("StyleChange", "\351\200\211\346\213\251\351\242\234\350\211\262", nullptr));
        label_4->setText(QCoreApplication::translate("StyleChange", "\345\255\227\344\275\223\351\242\234\350\211\262\357\274\232", nullptr));
        youtext->setText(QString());
        pushButton_4->setText(QCoreApplication::translate("StyleChange", "\351\200\211\346\213\251\351\242\234\350\211\262", nullptr));
        tabWidget->setTabText(tabWidget->indexOf(tab), QCoreApplication::translate("StyleChange", "\350\201\212\345\244\251\346\260\224\346\263\241", nullptr));
        groupBox_3->setTitle(QCoreApplication::translate("StyleChange", "\345\233\276\347\211\207\350\203\214\346\231\257", nullptr));
        pushButton_5->setText(QCoreApplication::translate("StyleChange", "\351\200\211\346\213\251\345\233\276\345\203\217\346\226\207\344\273\266", nullptr));
        label_5->setText(QString());
        groupBox_4->setTitle(QCoreApplication::translate("StyleChange", "\347\272\257\350\211\262\350\203\214\346\231\257", nullptr));
        back->setText(QString());
        pushButton_6->setText(QCoreApplication::translate("StyleChange", "\351\200\211\346\213\251\351\242\234\350\211\262", nullptr));
        tabWidget->setTabText(tabWidget->indexOf(tab_2), QCoreApplication::translate("StyleChange", "\350\201\212\345\244\251\350\203\214\346\231\257", nullptr));
        tabWidget->setTabText(tabWidget->indexOf(tab_3), QCoreApplication::translate("StyleChange", "\345\244\264\345\203\217", nullptr));
    } // retranslateUi

};

namespace Ui {
    class StyleChange: public Ui_StyleChange {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_STYLECHANGE_H
