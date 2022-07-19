import sys                     # 시스템 접근 모듈
from PyQt5.QtWidgets import *  # 윈도우 창 만들기 모듈

app = QApplication(sys.argv)   # 윈도우 창 객체 생성
label = QLabel("Hello")
label.show()
app.exec_()                    # 윈도우 창 객체 실행