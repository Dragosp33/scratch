# scratch
Aplicatie android in java, pentru publicarea si afisarea anunturilor.
Aplicatia este in genul E-bay/amazon/OLX unde un utilizator isi poate crea cont / loga direct in cont, iar mai apoi
poate vedea anunturi sau poate chiar adauga un anunt propriu. Utilizatorul poate vizualiza anunturi si
intra in contact cu vanzatorul

# Implementat:

- Sistem signup/login cu baza de date ROOM
- Google account link-up
- Mentinerea unei sesiuni pentru utilizatorul logat chiar si dupa inchiderea completa a aplicatiei in SessionManager cu ajutorul shared_prefferences
- Mentinerea anunturilor in fragmente pentru refolosire
- Vizualizarea anunturilor cu un adaptor recycler view

# TO DO:
- Adaugarea unei noi activitati pentru profilul userului cu multiple actiuni : schimbare poza de profil, parola, etc.
- Adaugarea unei noi activitati pentru vizualizarea unui anunt ( pentru a putea lua legatura cu vanzatorul )
- Login as guest
- Responsive design in functie de device ul de pe care este accesata aplicatia
- Scheduled jobs / notifications