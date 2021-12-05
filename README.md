
# ShipTracing  
  
Program monitoruje statki znajdujące się w wyznaczonym niebieskim prostokątem obszarze przy zachodnim wybrzeżu Norwegii.  
Po najechaniu na ikonę statku pojawi się niebieska linia wskazująca port do którego zmierza statek.
Po naciśnięciu na ikonę statku pojawi się popup wraz z nazwą statku oraz czerwona linia. Czerwona linia oznacza drogę jaką w ostatnim czasie pokonał statek.

![Widok mapy ze statkami](https://user-images.githubusercontent.com/95576808/144765550-11a6b2cb-2017-4958-ab09-6097c282c738.jpg)

Punkty wskazujące porty czasami mogą być niedokładne, wynika to z czasami niezbyt jasnych opisów portu w API Barentswatch co ma później przełożenie na mylne wyniki uzyskiwane z geocodingu. 
Dane portów z racji, że się nie zmieniają są cache'owane w bazie danych, tak aby co chwilę ich nie pobierać i nie marnować limitów api.

## Jak uruchomić 
Aby móc uruchomić należy mieć stworzone konta w serwisach:

 - [Barentswatch](https://www.barentswatch.no/) - API z danymi AIS
 - [Positionstack](https://positionstack.com/) - API do pobierania danych geocodingu

i posiadać dane potrzebne do korzystania z tych API

Następnie po pobraniu repozytorium w głównym folderze znajduje się plik docker-compose.yml
Trzeba w nim znaleźć linie 25-27 tzn:

    ships-api.clientId: # Setup your Barentswatch API client id
    ships-api.secret: #Setup your Barentswatch API secret
    geocoding.apiKey: #Setup here secret key for geocoding API http://api.positionstack.com/

Należy te propertiesy uzupełnić danymi dostępowymi do API.
Nastepnie w konsoli na poziomie głównego katalogu:

 - Budujemy obraz dockera komendą: `docker build -t ships-monitoring .` - ten krok może potrwać dłuższą chwilę, gdyż będą pobierane zależności Mavenowe.
 - Uruchamiamy nasz zbudowany obraz wraz z bazą danych komendą: `docker-compose up`

W przeglądarce internetowej wchodzimy na adres: `http://localhost:8080`

## Wykorzystane technologie

 - Java, 
 - Spring
 - Spring Data wraz z Hibernate
 - Deklaratywny klient Feign
 - Postgresql
 - Docker wraz z docker compose
 - Biblioteka do wyświetlania map Leaflet

## Brakujące elementy
W tej aplikacji z powodu braku czasu zabrakło wielu elementów, które z pewnością by się przydały, a oto kilka z nich:

 - Testy - brakuje testów(szczególnie całych przypadków w np. wiremocku), by mieć pewność przy dalszej rozbudowie aplikacji czy nic się nie zepsuło
 - Zapisywanie historii trasy statku - w obecnej chwili jest prezentowana trasa, która jest pobierana z API, tam jednak jest tylko z ograniczonego czasu (chyba 24h) można by pod spodem(przy pomocy jakiegoś schedulera) odpytywać o trasę, zapisywać do bazy i prezentować z dłuższego przedziału czasu.
 - Obliczanie przybliżonej długości narysowanej trasy
 - Segregowanie statków w zależności od typu i inne ich wyświetlanie
 - Alerty czy w danym obszarze pojawił się jakiś statek
 - Poszukanie innych API czy jest jakieś co udostępnia zmianę danych jako jakieś eventy wysyłane przez websockety albo kolejkę, żeby zrobić monitoring bardziej real time ;)

  
##  Informacje końcowe
Wykorzystane ikony zostały pobrane z serwisu: [Flaticon](www.flaticon.com)
