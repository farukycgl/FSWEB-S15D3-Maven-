package org.example.entity;

import java.util.HashMap;
import java.util.Map;

public class WordCounter {


    public static Map<String, Integer> calculatedWord() {

        String text = "When the offensive resumed, the Turks received their first victory when the Greeks encountered stiff resistance in the battles of First and Second İnönü," + " due to İsmet Pasha's organization of an irregular militia into a regular army. " + " The two victories led to Allied proposals to amend the Treaty of Sèvres where both Ankara and Istanbul were represented, but Greece refused." + " With the conclusion of the Southern and Eastern fronts, Ankara was able to concentrate more forces on the West against the Greeks." + " They also began to receive support from Soviet Union, as well as France and Italy, who sought to check British influence in the Near East.\n" + " June–July 1921 saw heavy fighting in the Battle of Kütahya-Eskişehir. While it was an eventual Greek victory, the Turkish army withdrew in good order to the Sakarya river, their last line of defence." + " Mustafa Kemal Pasha replaced İsmet Pasha after the defeat as commander in chief as well as his political duties." + " The decision was made in the Greek military command to march on the nationalist capital of Ankara to force Mustafa Kemal to the negotiating table." + " For 21 days, the Turks and Greeks fought a pitched battle at the Sakarya river, which ended in Greek withdrawal." + " Almost of year of stalemate without much fighting followed, during which Greek moral and discipline faltered while Turkish strength increased." + " French and Italian forces evacuated from Anatolia. The Allies offered an armistice to the Turks, which Mustafa Kemal refused.";

        //büyük-küçük harf farkı olmaması için küçük harfe çeviriyoruz.
        text = text.toLowerCase();

        //noktalama işaretlerini kaldırıyoruz.
        text = text.replaceAll("[^a-zA-ZçğıöşüÇĞİÖŞÜ\\s]", "");

        //kelimelere ayırıyoruz.
        String[] kelimeler = text.split("\\s+");

        //sonuçları tutmak için bir HashMap oluşturuyoruz.
        Map<String, Integer> kelimeSayaci = new HashMap<>();

        //her kelimeyi tek tek dolaşıp map'e ekliyoruz.
        for(String kelime : kelimeler) {
            if(kelime.isEmpty()){
                continue; //--> boş kelime varsa atlıyoruz.
            }
            if(kelimeSayaci.containsKey(kelime)) {
                kelimeSayaci.put(kelime, kelimeSayaci.get(kelime)+1); //daha önce eklendiyse 1 artır.
            }else{
                kelimeSayaci.put(kelime, 1); //daha önce eklenmemişse 1 olarak başlat.
            }
        }
        return kelimeSayaci;
    }
}
