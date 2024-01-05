/********************************************************************************
** Form generated from reading UI file 'home.ui'
**
** Created by: Qt User Interface Compiler version 5.13.2
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_HOME_H
#define UI_HOME_H

#include <QtCore/QVariant>
#include <QtGui/QIcon>
#include <QtWidgets/QAction>
#include <QtWidgets/QApplication>
#include <QtWidgets/QHBoxLayout>
#include <QtWidgets/QListWidget>
#include <QtWidgets/QPlainTextEdit>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QSpacerItem>
#include <QtWidgets/QSplitter>
#include <QtWidgets/QVBoxLayout>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_Home
{
public:
    QAction *refresh;
    QHBoxLayout *horizontalLayout_2;
    QSplitter *splitter_2;
    QWidget *verticalLayoutWidget_2;
    QVBoxLayout *verticalLayout;
    QListWidget *listWidget;
    QVBoxLayout *verticalLayout_3;
    QHBoxLayout *horizontalLayout_3;
    QPushButton *pushButton_4;
    QPushButton *pushButton_2;
    QHBoxLayout *horizontalLayout_4;
    QPushButton *pushButton_6;
    QPushButton *pushButton_5;
    QSplitter *splitter;
    QWidget *verticalLayoutWidget;
    QVBoxLayout *verticalLayout_2;
    QWidget *layoutWidget;
    QVBoxLayout *verticalLayout_11;
    QHBoxLayout *horizontalLayout_6;
    QPushButton *pushButton_9;
    QPushButton *pushButton_10;
    QPushButton *pushButton_8;
    QPushButton *pushButton_11;
    QPushButton *pushButton_7;
    QPushButton *pushButton_3;
    QPushButton *pushButton_12;
    QSpacerItem *horizontalSpacer;
    QHBoxLayout *horizontalLayout;
    QPlainTextEdit *textEdit_2;
    QVBoxLayout *verticalLayout_9;
    QPushButton *pushButton;
    QSpacerItem *verticalSpacer;

    void setupUi(QWidget *Home)
    {
        if (Home->objectName().isEmpty())
            Home->setObjectName(QString::fromUtf8("Home"));
        Home->resize(980, 735);
        QIcon icon;
        icon.addFile(QString::fromUtf8(":/image/ico"), QSize(), QIcon::Normal, QIcon::Off);
        Home->setWindowIcon(icon);
        refresh = new QAction(Home);
        refresh->setObjectName(QString::fromUtf8("refresh"));
        horizontalLayout_2 = new QHBoxLayout(Home);
        horizontalLayout_2->setObjectName(QString::fromUtf8("horizontalLayout_2"));
        splitter_2 = new QSplitter(Home);
        splitter_2->setObjectName(QString::fromUtf8("splitter_2"));
        splitter_2->setOrientation(Qt::Horizontal);
        verticalLayoutWidget_2 = new QWidget(splitter_2);
        verticalLayoutWidget_2->setObjectName(QString::fromUtf8("verticalLayoutWidget_2"));
        verticalLayout = new QVBoxLayout(verticalLayoutWidget_2);
        verticalLayout->setObjectName(QString::fromUtf8("verticalLayout"));
        verticalLayout->setContentsMargins(0, 0, 0, 0);
        listWidget = new QListWidget(verticalLayoutWidget_2);
        listWidget->setObjectName(QString::fromUtf8("listWidget"));
        QFont font;
        font.setPointSize(11);
        listWidget->setFont(font);
        listWidget->setIconSize(QSize(64, 64));
        listWidget->setViewMode(QListView::ListMode);

        verticalLayout->addWidget(listWidget);

        verticalLayout_3 = new QVBoxLayout();
        verticalLayout_3->setObjectName(QString::fromUtf8("verticalLayout_3"));
        horizontalLayout_3 = new QHBoxLayout();
        horizontalLayout_3->setObjectName(QString::fromUtf8("horizontalLayout_3"));
        pushButton_4 = new QPushButton(verticalLayoutWidget_2);
        pushButton_4->setObjectName(QString::fromUtf8("pushButton_4"));
        QIcon icon1;
        icon1.addFile(QString::fromUtf8(":/image/add.png"), QSize(), QIcon::Normal, QIcon::Off);
        pushButton_4->setIcon(icon1);

        horizontalLayout_3->addWidget(pushButton_4);

        pushButton_2 = new QPushButton(verticalLayoutWidget_2);
        pushButton_2->setObjectName(QString::fromUtf8("pushButton_2"));
        QIcon icon2;
        icon2.addFile(QString::fromUtf8(":/image/cash.png"), QSize(), QIcon::Normal, QIcon::Off);
        pushButton_2->setIcon(icon2);

        horizontalLayout_3->addWidget(pushButton_2);


        verticalLayout_3->addLayout(horizontalLayout_3);

        horizontalLayout_4 = new QHBoxLayout();
        horizontalLayout_4->setObjectName(QString::fromUtf8("horizontalLayout_4"));
        pushButton_6 = new QPushButton(verticalLayoutWidget_2);
        pushButton_6->setObjectName(QString::fromUtf8("pushButton_6"));
        QIcon icon3;
        icon3.addFile(QString::fromUtf8(":/image/C:/Users/i/Downloads/profile 2.png"), QSize(), QIcon::Normal, QIcon::Off);
        pushButton_6->setIcon(icon3);

        horizontalLayout_4->addWidget(pushButton_6);

        pushButton_5 = new QPushButton(verticalLayoutWidget_2);
        pushButton_5->setObjectName(QString::fromUtf8("pushButton_5"));
        QIcon icon4;
        icon4.addFile(QString::fromUtf8(":/image/C:/Users/i/Downloads/paint_palette.png"), QSize(), QIcon::Normal, QIcon::Off);
        pushButton_5->setIcon(icon4);

        horizontalLayout_4->addWidget(pushButton_5);


        verticalLayout_3->addLayout(horizontalLayout_4);


        verticalLayout->addLayout(verticalLayout_3);

        splitter_2->addWidget(verticalLayoutWidget_2);
        splitter = new QSplitter(splitter_2);
        splitter->setObjectName(QString::fromUtf8("splitter"));
        splitter->setOrientation(Qt::Vertical);
        verticalLayoutWidget = new QWidget(splitter);
        verticalLayoutWidget->setObjectName(QString::fromUtf8("verticalLayoutWidget"));
        verticalLayout_2 = new QVBoxLayout(verticalLayoutWidget);
        verticalLayout_2->setObjectName(QString::fromUtf8("verticalLayout_2"));
        verticalLayout_2->setContentsMargins(0, 0, 0, 0);
        splitter->addWidget(verticalLayoutWidget);
        layoutWidget = new QWidget(splitter);
        layoutWidget->setObjectName(QString::fromUtf8("layoutWidget"));
        verticalLayout_11 = new QVBoxLayout(layoutWidget);
        verticalLayout_11->setObjectName(QString::fromUtf8("verticalLayout_11"));
        verticalLayout_11->setContentsMargins(0, 0, 0, 0);
        horizontalLayout_6 = new QHBoxLayout();
        horizontalLayout_6->setObjectName(QString::fromUtf8("horizontalLayout_6"));
        pushButton_9 = new QPushButton(layoutWidget);
        pushButton_9->setObjectName(QString::fromUtf8("pushButton_9"));
        QIcon icon5;
        icon5.addFile(QString::fromUtf8(":/image/C:/Users/i/Downloads/\346\226\207\346\241\243\347\261\273\345\236\213-\345\233\276\347\211\207.png"), QSize(), QIcon::Normal, QIcon::Off);
        pushButton_9->setIcon(icon5);
        pushButton_9->setAutoDefault(false);
        pushButton_9->setFlat(false);

        horizontalLayout_6->addWidget(pushButton_9);

        pushButton_10 = new QPushButton(layoutWidget);
        pushButton_10->setObjectName(QString::fromUtf8("pushButton_10"));
        QIcon icon6;
        icon6.addFile(QString::fromUtf8(":/image/C:/Users/i/Downloads/\346\226\207\344\273\266.png"), QSize(), QIcon::Normal, QIcon::Off);
        pushButton_10->setIcon(icon6);
        pushButton_10->setFlat(false);

        horizontalLayout_6->addWidget(pushButton_10);

        pushButton_8 = new QPushButton(layoutWidget);
        pushButton_8->setObjectName(QString::fromUtf8("pushButton_8"));
        QIcon icon7;
        icon7.addFile(QString::fromUtf8(":/image/C:/Users/i/Downloads/bqb.png"), QSize(), QIcon::Normal, QIcon::Off);
        pushButton_8->setIcon(icon7);

        horizontalLayout_6->addWidget(pushButton_8);

        pushButton_11 = new QPushButton(layoutWidget);
        pushButton_11->setObjectName(QString::fromUtf8("pushButton_11"));
        QIcon icon8;
        icon8.addFile(QString::fromUtf8(":/avatar/\347\272\242\345\214\205.png"), QSize(), QIcon::Normal, QIcon::Off);
        pushButton_11->setIcon(icon8);

        horizontalLayout_6->addWidget(pushButton_11);

        pushButton_7 = new QPushButton(layoutWidget);
        pushButton_7->setObjectName(QString::fromUtf8("pushButton_7"));
        QIcon icon9;
        icon9.addFile(QString::fromUtf8(":/image/C:/Users/i/Downloads/\351\223\203\351\223\233\345\270\246\345\234\210.png"), QSize(), QIcon::Normal, QIcon::Off);
        pushButton_7->setIcon(icon9);
        pushButton_7->setIconSize(QSize(20, 20));

        horizontalLayout_6->addWidget(pushButton_7);

        pushButton_3 = new QPushButton(layoutWidget);
        pushButton_3->setObjectName(QString::fromUtf8("pushButton_3"));
        QIcon icon10;
        icon10.addFile(QString::fromUtf8(":/image/C:/Users/i/Downloads/ic_cleaning_junk.png"), QSize(), QIcon::Normal, QIcon::Off);
        pushButton_3->setIcon(icon10);

        horizontalLayout_6->addWidget(pushButton_3);

        pushButton_12 = new QPushButton(layoutWidget);
        pushButton_12->setObjectName(QString::fromUtf8("pushButton_12"));
        QIcon icon11;
        icon11.addFile(QString::fromUtf8(":/image/\351\272\246\345\205\213\351\243\216ico.png"), QSize(), QIcon::Normal, QIcon::Off);
        pushButton_12->setIcon(icon11);

        horizontalLayout_6->addWidget(pushButton_12);

        horizontalSpacer = new QSpacerItem(40, 20, QSizePolicy::Expanding, QSizePolicy::Minimum);

        horizontalLayout_6->addItem(horizontalSpacer);


        verticalLayout_11->addLayout(horizontalLayout_6);

        horizontalLayout = new QHBoxLayout();
        horizontalLayout->setObjectName(QString::fromUtf8("horizontalLayout"));
        textEdit_2 = new QPlainTextEdit(layoutWidget);
        textEdit_2->setObjectName(QString::fromUtf8("textEdit_2"));

        horizontalLayout->addWidget(textEdit_2);

        verticalLayout_9 = new QVBoxLayout();
        verticalLayout_9->setObjectName(QString::fromUtf8("verticalLayout_9"));
        pushButton = new QPushButton(layoutWidget);
        pushButton->setObjectName(QString::fromUtf8("pushButton"));
        QIcon icon12;
        icon12.addFile(QString::fromUtf8(":/image/C:/Users/i/Downloads/\347\272\270\351\243\236\346\234\272.png"), QSize(), QIcon::Normal, QIcon::Off);
        pushButton->setIcon(icon12);
        pushButton->setIconSize(QSize(32, 32));

        verticalLayout_9->addWidget(pushButton);

        verticalSpacer = new QSpacerItem(20, 40, QSizePolicy::Minimum, QSizePolicy::Expanding);

        verticalLayout_9->addItem(verticalSpacer);


        horizontalLayout->addLayout(verticalLayout_9);


        verticalLayout_11->addLayout(horizontalLayout);

        splitter->addWidget(layoutWidget);
        splitter_2->addWidget(splitter);

        horizontalLayout_2->addWidget(splitter_2);


        retranslateUi(Home);

        pushButton_9->setDefault(false);


        QMetaObject::connectSlotsByName(Home);
    } // setupUi

    void retranslateUi(QWidget *Home)
    {
        Home->setWindowTitle(QCoreApplication::translate("Home", "Telegraph", nullptr));
        refresh->setText(QCoreApplication::translate("Home", "\345\210\267\346\226\260\345\210\227\350\241\250", nullptr));
#if QT_CONFIG(tooltip)
        refresh->setToolTip(QCoreApplication::translate("Home", "\345\210\267\346\226\260\345\234\250\347\272\277\347\224\250\346\210\267\345\210\227\350\241\250", nullptr));
#endif // QT_CONFIG(tooltip)
        pushButton_4->setText(QCoreApplication::translate("Home", "\346\226\260\345\273\272\347\276\244\350\201\212", nullptr));
        pushButton_2->setText(QCoreApplication::translate("Home", "\345\205\205\345\200\274", nullptr));
        pushButton_6->setText(QCoreApplication::translate("Home", "\344\277\256\346\224\271\350\265\204\346\226\231", nullptr));
        pushButton_5->setText(QCoreApplication::translate("Home", "\344\270\252\346\200\247\345\214\226", nullptr));
        pushButton_9->setText(QCoreApplication::translate("Home", "\345\233\276\347\211\207", nullptr));
        pushButton_10->setText(QCoreApplication::translate("Home", "\346\226\207\344\273\266", nullptr));
        pushButton_8->setText(QCoreApplication::translate("Home", "\350\241\250\346\203\205", nullptr));
        pushButton_11->setText(QCoreApplication::translate("Home", "\347\272\242\345\214\205", nullptr));
        pushButton_7->setText(QCoreApplication::translate("Home", "\346\212\226\345\212\250", nullptr));
        pushButton_3->setText(QCoreApplication::translate("Home", "\346\270\205\345\261\217", nullptr));
        pushButton_12->setText(QCoreApplication::translate("Home", "\350\257\255\351\237\263", nullptr));
        pushButton->setText(QCoreApplication::translate("Home", "\345\217\221\351\200\201", nullptr));
    } // retranslateUi

};

namespace Ui {
    class Home: public Ui_Home {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_HOME_H
