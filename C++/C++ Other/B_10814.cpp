//
// Created by SeMin on 2020-03-13.
//

#include <iostream>
#include <string>
#include <algorithm>
using namespace std;
class Person{
public:
    int num;
    int age;
    string name;
    Person(){

    };
};
bool compare(Person &a, Person &b){

    if(a.age == b.age)
        return a.num < b.num;
    return a.age < b.age;
}
int main(){
    int size;
    cin>> size;
    Person *arr = new Person[size];
    for(int i = 0; i<size; ++i){
        int age;
        string name;
        cin >> age;
        cin >> name;
        arr[i].num = i;
        arr[i].age = age;
        arr[i].name = name;
    }
    sort(arr, arr + size, compare);
    for(int i = 0; i<size; ++i){
        cout << arr[i].age << ' '<< arr[i].name << '\n';
    }
    return 0;

}