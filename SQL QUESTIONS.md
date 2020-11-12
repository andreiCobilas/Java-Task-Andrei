##1Câte documente sunt în toate arhivele?##

SELECT COUNT(*)
FROM document
WHERE document_id IS NOT NULL;

##2 Selectati numele documentului cu cea mai mare dimensiune (document_size)##

SELECT document_name
HAVING MAX(document_size);

##3 Selectați id-ul arhivelor care au modul de licențiere (licensing_mode) per număr document##

SELECT archive_id
FROM document
GROUP BY liccensing_mode;

##4 Cate arhivele sunt în aplicație care conțin mai mult de 1000 de documente##

SELECT archive_id, COUNT(*)
FROM documents
WHERE COUNT > 1000
GROUP by archive_id;

##5 Selectați id-ul documentelor a căror dimensiune e între 10 și 20 de Megabytes##

SELECT document_id
FROM documents
WHERE document_size BETWEEN  10 and 20;

##6 Numele arhivei care contine cele mai multe documente##

SELECT archive_name
FROM documents HAVING MAX(SELECT archive_id, COUNT(*) mycount 
FROM documents
GROUP by archive_id );

##7Utilizatorii care au acces pe minim 2 arhive și sunt din orașul Chișinău##

SELECT user_id
FROM users
WHERE COUNT(archive_id) >=2 AND birth_city = 'Chisinau';

##8 Câți useri sunt în fiecare oraș ?##

SELECT user_id, COUNT(*)
FROM users
GROUP by birth_city;

##9 Selectați numele arhivei si numele administratorului, in cazul in care arhiva nu are un administrator ##

alocat atunci se va afisa valoarea NULL. Indiciu (utilizați LEFT JOIN)
SELECT archive.archive_name AS ar, users.user_firs_name As ad
FROM archive 
LEFT JOIN ad.user_id ON ar.admin_id;

##10Selectați numele tuturor arhivelor și numele tuturor documentelor întro singură coloana##

SELECT archive.archive_id, document.documents_id
FROM document AS A INNER JOIN archive AS B ON A.documents_id = B.archive_id;

##11Selectati numele si prenumele utilizatorilor care au acces la orice arhivă și a căror nume de familie începe cu litera ”A”. Rezultatul nu trebuie să conțină duplicate.##

SELECT DISTINCT user_firs_name, user_last_name,
FROM users
GROUP by user_id
WHERE user_last_name LIKE 'A%';