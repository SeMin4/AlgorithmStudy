#include<iostream>
#include<string>
#include<list>
using namespace std;

int main() {
    int n;
    string s; //�ʱ� �Է� ���ڿ�
    cin >> s; //abcd
    cin >> n;
    list<char> editor(s.begin(), s.end()); // ���ڿ��� ����Ʈ��  
    auto cursor = editor.end(); // �ʱ� Ŀ���� ��ġ�� ������ �� ��
    while (n--) {// ����� �� ��ŭ �ݺ� 
        char cmd;
        cin >> cmd; //��ɾ� �Է� 
        if (cmd == 'L') {
            if (cursor != editor.begin()) {
                cursor--;
            }
        }
        else if (cmd == 'D') {
            if (cursor != editor.end()) {
                cursor++;
            }
        }
        else if (cmd == 'B') {
            if (cursor != editor.begin()) {
                cursor--;
                cursor = editor.erase(cursor);
            }
        }

        else if (cmd == 'P') {
            char x;
            cin >> x;
            editor.insert(cursor, x);
        }
    }
    for (auto& x : editor) {
        cout << x;
    }
    return 0;
}


