# Das Projekt

Dieses Projekt ist ein Teil meiner Vision der Programmierung eines eigenen Fahrgastinformationssystems. Als ersten Schritt habe ich eine Bahnhofsanzeige für einen Bahnhof, nämlich "Frankfurt (Main) Süd" implementiert, dabei können die Daten verwaltet, Fahrten hinzugefügt, gelöscht und die Zwischenhalte eingestellt werden. Mittel- bis langfristig sind noch mehr Funktionen geplant. Unter anderem soll die Bahnhofsanzeige auf bestimmte Gleise individualisierbar gemacht und ein Zufallsgenerator für Verspätungen eingefügt werden. 
Des Weiteren sollen die Fahrten auf Wochentage anpassbar gemacht werden, sodass es möglich sein soll, einen geänderten Fahrplan zum Beispiel für Wochenendtage zu erstellen.

Mehrere Bahnhöfe soll man auswählen und einen eigenen Liniennetzplan erstellen können.

In regelmäßigen Abständen sind Updates geplant und das Programm soll langfristig als .EXE-Datei angeboten werden.

Doch genug von Träumereien (Träume werden später trotzdem wahr), in den nächsten Abständen geht es detaillierter um die aktuelle Version.

# Installieren des Projektes in Ihrer IDE:

**UPDATE: Externe Libraries wurden dem lib-Ordner hinzugefügt. Sie brauchen diese nur noch dem Compiler mitzuteilen, indem sie die lib-Ordner oder die jar-Dateien als Classpath hinterlegen.**



Um dieses Projekt in Ihrer IDE zu laden und abzuspielen sind mehrere Voraussetzungen nötig, es müssen erstens einige Libraries installiert werden und zweitens benötigt es die richtige Datenbank. 
Ich erkläre nun nacheinander die Schritte zum Aufsetzen des Programmes, damit dieses auch auf Ihrem System einwandfrei läuft.
Ich benutze IntelliJ IDEA als Entwicklungsumgebung, falls Sie eine andere IDE benutzen ist dies kein größeres Problem, lediglich funktioniert die Integration/ Installation ein wenig anders.

## Integrieren der Java-Libraries

Am Anfang sei gesagt, dass Sie auch Build-Tools wie Maven oder Gradle benutzen können. Ich habe hierauf allerdings bei meiner Implementation verzichtet.

### Java FX (Grafische Benutzeroberfläche)

Um Java FX zu laden sind mehrere Voreinstellungen nötig. Befolgen Sie folgende Schritte:
1. Laden Sie die JavaFX-SDK herunter, ich nutze die "javafx-sdk-19"
2. Fügen Sie die VM Options in IntelliJ wie folgt hinzu:
- öffnen Sie §Run -> Edit Configurations
- klicken Sie auf "Modify options"
- wählen Sie "Add VM Options"
- fügen Sie in das neue Feld diesen Text ein:
```
--module-path "Ihr\Pfad\zu\javafx-sdk-19\lib" --add-modules javafx.controls,javafx.fxml
```
- speichern
3. Integrieren Sie diesen Pfad "Ihr\Pfad\zu\javafx-sdk-19\lib" in Ihr Projekt:
- Rechtsklick auf das Projekt -> Open Module Settings
- Wählen Sie links im Baum den Eintrag Project "Settings -> Libraries" aus
- Klicken Sie auf "+ -> Java" und navigieren zum lib-Ordner der JavaFX-SDK

### MySQL Connector (Datenbankanbindung)

Führen Sie nur Schritt 3 analog zu den Anweisungen bezüglich der Java FX-Integration durch.
Integrieren Sie dabei nicht den lib-Ordner sondern nur eine einzige jar-Datei, bei mir heißt sie "mysql-connector-j-8.0.31".

### Jackson (JSON-Datei-Einbindung)

Die Jackson-Library wird benötig um die Zusammenarbeit mit JSON-Dateien zu ermöglichen.
Ich benutze die Version "jackson-2.14". Integrieren Sie den gesamten Ordner "Ihr\Pfad\zu\jackson-2.14".

### MaryTTS (Ansagen mit einer Computerstimme)

Integrieren Sie die Library "marytts-5.0" und laden Sie den lib-Ordner zu ihren Libraries, wie in Schritt 3 des Kapitels "Java FX" erklärt.
Die MaryTTS-Library ermöglicht Ansagen mit einer Computerstimme.

## Erstellen der Datenbankanbindung

Hierfür müssen Sie in Ihrer MySQL-Datenbank nur einen einzige SQL-Datei ausführen, danach wird die Datenbank und alle Testdaten erstellt.
Die Datei befindet sich im Projekt unter diesem Pfad: "resources/SQL-Files/create_database_withMuchSampleData.sql".
Ich nutzte die MySQL-Workbench zum Ausführen der Datei.

# Einblicke in das Programm

Um Ihnen schonmal einen ersten Eindruck der Software zu geben, anbei ein paar Aufnahmen:

![Bild kann nicht geladen werden](resources/img/forReadMe/bahnhofsanzeige.png?raw=true)

![Bild kann nicht geladen werden](resources/img/forReadMe/fahrtenhinzufuegen.png?raw=true)

![Bild kann nicht geladen werden](resources/img/forReadMe/fahrtenverwalten.png?raw=true)

![Bild kann nicht geladen werden](resources/img/forReadMe/zwischenhalte.png?raw=true)

# Noch Fragen?

Scheuen Sie sich bitte nicht mich zu fragen, falls etwas unklar sein sollte.
Mich erreichen Sie unter: maxim.neumann@gmx.net

Ich wünsche ganz viel Spaß beim Programmieren und Ausprobieren.