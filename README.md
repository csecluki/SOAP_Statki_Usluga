# SOAP_Statki_Usluga

Usługa sieciowa na serwerze Glassfish. Przechowuje ona informacje o statkach i portach dodanych przez klientów. Jej głównym zadaniem jest obliczanie czasu, w jakim dany statek dotrze do wskazanego portu. Klient wysyła numer statku oraz jego pozycję (dla ułatwienia są to 2 dodatnie liczby całkowite) wraz z docelowym portem i prędkością - zarówno statek jak i port muszą być wcześniej zgłoszone. W odpowiedzi otrzymuje ilość godzin, jaka zajmie statkowi podróż do wsazanego portu. Usługa zwraca również informacje o statku, gdy klient wyśle odpowiednie żądanie.

Klient do tej usługi znajduje się tu: https://github.com/csecluki/SOAP_Statki_Klient.
