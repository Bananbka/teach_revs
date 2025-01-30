# -*- coding: utf-8 -*-

import os
import asyncio
import json
from googletrans import Translator # type: ignore

import nltk # type: ignore
# nltk.download(['punkt_tab', 'stopwords', 'averaged_perceptron_tagger_eng', 'vader_lexicon', 'punkt', 'averaged_perceptron_tagger'])
from nltk.sentiment.vader import SentimentIntensityAnalyzer # type: ignore
from nltk.tokenize import word_tokenize # type: ignore
from nltk.corpus import stopwords # type: ignore



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
    raw = ""
    with open("../data/request.txt", "r", encoding="utf-8") as request_file:
        raw = await translate_text(request_file.read(), "en")
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

    os.makedirs("../data", exist_ok=True)
    with open("../data/result.json", "w",  encoding="utf-8") as result_file:
        json.dump(list_result, result_file)

asyncio.run(main())
