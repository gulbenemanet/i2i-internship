#!/bin/bash

toplam(){
    result=$((num1 + num2))
    echo "Sonuç: $result"
}

eksi(){
    result=$((num1 - num2))
    echo "Sonuç: $result"
}

carp(){
    result=$((num1 * num2))
    echo "Sonuç: $result"
}

bol(){
    if [[ $num2 -eq 0 ]]; then
        echo "Hata: 0'a bölünemez."
    else
        result=$((num1 / num2))
        echo "Sonuç: $result"
    fi
}

mod(){
    if [[ $num2 -eq 0 ]]; then
        echo "Hata: 0'a bölünemez."
    else
        result=$((num1 % num2))
        echo "Sonuç: $result"
    fi
}

echo "Yapmak istediğiniz işlemi seçin<:
1	+ (addition)
2	– (subtraction)
3	* (multiplication)
4	/ (division)
5	% (modulo)
6	!  (factorial)
"
read operation

if [ $operation -eq 6 ]; then 
    echo "Faktöriyelini hesaplamak istediğiniz sayıyı girin."
    read numb1
    factorial=1
    while [ $numb1 -gt 1 ]; do
        factorial=$((factorial * numb1))
        numb1=$((numb1 - 1))
    done
    echo $factorial
	exit 0
fi

echo "Birinci sayıyı girin:"
read num1
echo "İkinci sayıyı girin:"
read num2
case $operation in
    1) toplam ;;
    2) eksi ;;
    3) carp ;;
    4) bol ;;
    5) mod ;;
    *) echo "Invalid choice" ;;
esac
