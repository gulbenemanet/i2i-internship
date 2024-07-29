# My New Repo

## Proje Hakkında
Bu proje, bir Git senaryosunu uygulamayı amaçlamaktadır. Senaryoda mevcut bir versiyon üzerinde hata düzeltmesi yapılmakta ve bu düzeltme diğer versiyonlara aktarılmaktadır.

## Senaryo
- Üretimde kullanılan ürün versiyonu: `r2.5.4`
- Gelecekte yayınlanacak versiyon: `r2.5.5`
- Geliştirme aşamasında olan versiyon: `r3.0`
- `r2.5.4` versiyonunda bir hata oluştu ve bu hatayı düzeltmek için `r2.5.4.1 Bugfix` adında bir dal oluşturuldu. Bu değişiklikler hem `r2.5.5` dalına hem de `r3.0` dalına eklendi.

## Git Komutları

1. r2.5.4 Dalı Oluşturma ve Commit
    ```bash
    git checkout -b r2.5.4
    echo "Version 2.5.4 code" > code.txt
    git add code.txt
    git commit -m "Add initial code for r2.5.4"
    git push -u origin r2.5.4
    ```

2. r2.5.5 ve r3.0 Dallarını Oluşturma
    ```bash
    Kodu kopyala
    git checkout -b r2.5.5
    git push -u origin r2.5.5
    git checkout -b r3.0
    git push -u origin r3.0
    ```

3. Hata Düzeltmesi İçin r2.5.4.1 Bugfix Dalını Oluşturma
    ```bash
    Kodu kopyala
    git checkout r2.5.4
    git checkout -b r2.5.4.1-Bugfix
    echo "Bug fix for version 2.5.4" > bugfix.txt
    git add bugfix.txt
    git commit -m "Fix bug in r2.5.4"
    git push -u origin r2.5.4.1-Bugfix
    ```

4. Değişiklikleri r2.5.5 ve r3.0 Dallarına Birleştirme
    ```bash
    Kodu kopyala
    git checkout r2.5.5
    git merge r2.5.4.1-Bugfix
    git push origin r2.5.5

    git checkout r3.0
    git merge r2.5.4.1-Bugfix
    git push origin r3.0
    ```