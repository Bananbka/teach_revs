# -*- coding: utf-8 -*-

import nltk # type: ignore
# nltk.download(['punkt_tab', 'stopwords', 'averaged_perceptron_tagger_eng', 'vader_lexicon', 'punkt', 'averaged_perceptron_tagger'])
from nltk.sentiment.vader import SentimentIntensityAnalyzer # type: ignore
from nltk.tokenize import word_tokenize # type: ignore
from nltk.corpus import stopwords # type: ignore

import asyncio
import json
from googletrans import Translator # type: ignore



async def split_to_segments(text):
    lenght = text.__len__()
    segments = lenght//3000 + 1
    segments_list = []
    for i in range(1, segments):
        try:
            seg_len = 3000
            while text[seg_len] not in ['.', '。', '!', '?'] : seg_len = seg_len - 1
            segments_list.append(text[0:seg_len+1])
            text = text.replace(segments_list[i-1], "")   
        except Exception as e: 
            print(e)
    segments_list.append(text)
    return segments_list

async def translate_text(text, translate_to):
    translate_result = ""
    text_list = await split_to_segments(text)
    async with Translator() as translator:
        for segment in text_list:
            result = await translator.translate(segment, dest=translate_to)
            translate_result=translate_result + result.text
    return translate_result



async def main():
    raw = await translate_text("""
Der Lehrer ist fantastisch! Ich habe viel gelernt.
Sehr hilfreich, aber ich wünschte, die Erklärungen wären detaillierter.
Ich fand den Kurs interessant, aber in einigen Konzepten hatte ich Schwierigkeiten.
Gute Kommunikation und großartige Beispiele im Unterricht.
Leider konnte ich das meiste nicht verstehen.
Ich liebe diesen Kurs! Jetzt fühle ich mich viel sicherer.
Es war nicht die beste Erfahrung. Der Lehrer schien nicht vorbereitet zu sein.
Ich schätze die klare Struktur des Kurses.
Einige Teile waren wirklich langweilig, aber der Lehrer hat es trotzdem spannend gemacht.
Der Lehrer ist sehr kompetent, aber das Tempo war zu schnell.
Einer der besten Lehrer, die ich je hatte! Sehr empfehlenswert.
Ich habe nicht viel gelernt.
Der Lehrer macht den Unterricht sehr interessant und interaktiv!
Ich stimme einigen Methoden nicht zu, aber ich habe trotzdem etwas gelernt.
Die Erklärungen könnten klarer sein. Manchmal war ich verwirrt.
Sehr geduldig und hat alle meine Fragen beantwortet.
Ich wünschte, der Kurs hätte mehr praktische Aufgaben.
Sehr begeistert, aber der Inhalt war schwer zu folgen.
Das Feedback des Lehrers war sehr hilfreich und konstruktiv.
Für mich war das Tempo etwas zu schnell, aber insgesamt okay.
Der Lehrer hat alles sehr detailliert erklärt, und ich bin sehr dankbar dafür.
Ich fand den Kurs nicht herausfordernd genug, der Inhalt war zu einfach.
Der Lehrer ist großartig, aber die Kursorganisation war etwas chaotisch.
Ich mochte diese Unterrichtsmethode nicht, aber ich habe trotzdem etwas gelernt.
Der Kurs war klar, aber der Inhalt war etwas kompliziert.
Fantastisch! Jede Lektion war spannend!
Der Lehrer schien wenig Interesse zu haben, und die Atmosphäre war langweilig.
Ich mag die Lehrmethode des Lehrers, aber ich wünsche mir mehr Aktivitäten.
Sehr unterstützend und ermutigend, aber das Tempo war inkonsistent.
Ich konnte nicht ganz folgen, aber der Lehrer hat mir geholfen.
Der Lehrer hat schwierige Konzepte wirklich gut erklärt.
Ich mag das Kursformat nicht, aber der Lehrer ist in Ordnung.
Der Lehrer stellt sicher, dass jeder versteht, bevor er weitermacht.
Der Lehrer könnte mehr Beispiele im Unterricht geben.
Ich war sehr engagiert während des gesamten Kurses.
Technische Probleme haben den Kursfluss gestört.
Die Begeisterung des Lehrers hat den Unterricht sehr interessant gemacht!
Ich war mit dem Feedback des Lehrers nicht zufrieden, ich hätte mehr Details erwartet.
Die Lehrmethoden des Lehrers sind innovativ und halten mich interessiert.
Der Kurs war für mich etwas zu schwierig.
Der Lehrer ist immer bereit zu helfen und unterstützt uns.
Ich mochte den Unterrichtsstil nicht, aber ich habe den Inhalt verstanden.
Der Lehrer sollte während des Unterrichts mehr organisiert sein.
Der Lehrer hat den Inhalt interessant gemacht, obwohl er herausfordernd war.
Der Kurs war schwer zu folgen, aber ich habe viel gelernt.
Der Kurs könnte interaktiver sein, aber der Lehrer war trotzdem gut.
Ich fühlte mich etwas überfordert, aber der Lehrer war sehr unterstützend.
Der Lehrer erklärt sehr gut, aber ich hatte trotzdem Schwierigkeiten, ihm zu folgen.
Ich mag die Erklärungen des Lehrers, aber die Aufgaben sind zu schwierig.
Der Kurs war spannend, aber ich hätte gerne mehr praktische Beispiele gehabt.
Ein hervorragender Lehrer, der jedes Thema leicht verständlich gemacht hat.
Das Tempo war für mich gerade richtig, aber ich fand den Inhalt nicht ganz zutreffend.
Der Lehrer hat mich mit seiner Begeisterung für das Fach inspiriert.
Der Lehrer war zu streng, und die Atmosphäre im Kurs war unangenehm.
Ich habe in diesem Kurs nicht viel gelernt.
Das Feedback des Lehrers war sehr hilfreich und hat mir geholfen, mich zu verbessern.
Der Kurs war spannend, aber ich hätte gerne mehr Gruppendiskussionen gehabt.
Der Lehrer war immer freundlich und geduldig, aber das Tempo war zu langsam.
Ich mag die Begeisterung des Lehrers, aber der Kursinhalt hat mich nicht wirklich interessiert.
Der Lehrer hat wenig interagiert, und der Kurs war langweilig.
Der Kurs war sehr interaktiv, aber der Inhalt war schwer zu verstehen.
Ich denke, der Lehrer könnte flexibler mit den Abgabeterminen umgehen.
Der Lehrer hat mir das Gefühl gegeben, dass Lernen nicht stressig sein muss, was ich sehr schätze.
Der Kurs fühlt sich zu theoretisch an, es fehlt der praktische Bezug.
Der Lehrer stellt sicher, dass jeder versteht, bevor er weitermacht.
Der Kurs ist gut organisiert, aber der Lehrer könnte noch strukturierter sein.
Der Inhalt war zu einfach für mich, ich hätte mir mehr Herausforderungen gewünscht.
Der Lehrer hat viel Wissen und wertvolle Einblicke gegeben.
Ich war im Kurs etwas verwirrt, aber der Lehrer war sehr zugänglich.
Der Kurs war spannend, aber ich hätte gerne mehr konkrete Beispiele gesehen.
Der Lehrer ist sehr hilfsbereit, aber ich fand das Fach etwas langweilig.
Manchmal schien der Lehrer nicht so organisiert zu sein, aber ich habe viel gelernt.
Der Kurs war sehr spannend, aber in einigen Teilen hatte ich Schwierigkeiten.
Ich wurde durch die Begeisterung des Lehrers inspiriert!
Der Lehrer hat gut erklärt, aber der Kurs war manchmal zu schnell.
Ich mag den Unterrichtsstil des Lehrers, aber der Kursinhalt hat mich nicht wirklich gefesselt.
Der Lehrer hat sehr gut erklärt, aber der Kurs war manchmal schwer zu folgen.
Das Feedback des Lehrers war sehr konstruktiv und hat mir geholfen, mich zu verbessern.
Ich mag die Begeisterung des Lehrers, aber der Kurs hätte mehr Struktur vertragen können.
Der Lehrer konzentrierte sich zu sehr auf die Theorie und weniger auf die praktische Anwendung.
Ich finde den Kurs sehr hilfreich und mag die Art, wie der Lehrer unterrichtet.
Das Tempo war für mich genau richtig, aber der Inhalt entsprach nicht ganz meinen Zielen.
Der Lehrer hat den Unterricht spannend gemacht, aber ich hätte mir mehr Herausforderungen gewünscht.
Der Lehrer ist großartig, aber ich konnte mich nicht mit dem Inhalt identifizieren.
Der Kurs war gut organisiert, aber der Lehrer könnte noch etwas fesselnder sein.
Ich fand den Unterrichtsstil des Lehrers ein wenig repetitiv.
Der Lehrer hat viele gute Ressourcen angeboten, aber der Kursfortschritt war zu schnell.
Ich mochte diesen Kurs, aber ich fand einige Themen nicht gut erklärt.
Der Lehrer hat den Inhalt lebendig und interessant gemacht.
Der Kurs war schwer, aber der Lehrer war geduldig und hilfsbereit.
Ich schätze die Hilfe des Lehrers, aber ich konnte nicht mit dem Tempo mithalten.
Der Lehrer sollte auf Fragen schneller antworten.
Der Kurs war leicht zu verstehen, aber ich hätte mir mehr Herausforderungen gewünscht.
Die Beispiele des Lehrers waren sehr hilfreich, um komplexe Konzepte zu verstehen.
Der Lehrer war sehr begeistert, aber der Kursinhalt hat mich nicht wirklich interessiert.
Der Kurs war schwierig, aber der Lehrer hat mir sehr geholfen.
Der Lehrer hat den Inhalt spannend gemacht, aber ich hätte mir mehr Vielfalt gewünscht.
Der Kurs war interessant, aber ich hätte mehr Unterstützung bei einigen Themen gebraucht.
Der Lehrer hat viel Wissen, aber der Kurs war etwas eintönig.
Insgesamt mochte ich den Kurs, aber ich hätte mir eine strukturiertere Unterrichtsmethode gewünscht.
""", "en")
    tokens = word_tokenize(raw)
    tokens_lowercase = [w.lower() for w in tokens if w.isalpha()]
    stop_words = set(stopwords.words('english'))
    tokens_filtered = [w for w in tokens_lowercase if w not in stop_words]
    adjectives = []
    
    list_pos = nltk.pos_tag(tokens_filtered)
    adjectives = [word[0] for word in list_pos if word[1] == "JJ"]
    sia = SentimentIntensityAnalyzer()

    count_dict = {}
    for i in adjectives:
        word_count = adjectives.count(i)
        count_dict[i] = word_count

    list_result = []
    for i in count_dict.keys():
        polarity = sia.polarity_scores(i)["compound"]
        list_result.append({'name':i, 'count':count_dict[i], 'polarity':polarity})

    list_result.sort(key=lambda dict: dict['count'], reverse=True)

    with open("result.json", "w") as result_file:
        json.dump(list_result, result_file)

asyncio.run(main())
