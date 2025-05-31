package com.syukri.uaspbo.menu;

import com.syukri.uaspbo.Battle;

public class GuideNPC {
    public static void conversation(int dayCounter, String currentLocation){
        if(dayCounter == 0){
            Battle.waitAndClear();
            System.out.println("Ada kelompok misterius yang punya rencana lebih gelap: mengorbankan seluruh");
            System.out.println("Pokémon di dunia demi memanggil Dewa Pokémon, makhluk kuno yang katanya bisa");
            System.out.println("memberikan kekuatan absolut kepada siapa pun yang mengendalikannya.");
            Battle.waitAndClear();
            System.out.println("Digga, seorang trainer, mengajak kamu untuk mengumpulkan semua pokemon yang ada");
            System.out.println("demi menyelamatkan para pokemon.  kamu tentunya menolak karena tidak mau");
            System.out.println("berurusan dengan kelompok aneh tersebut. Digga mengajak Kembali sambil ");
            System.out.println("menambahkan “..kamu bisa mengetahui siapa ayahmu jika ikut bersamaku“.");
            Battle.waitAndClear();
            System.out.println("Kamu awalnya merasa itu adalah penawaran aneh, namun kamu  teringat pesan ibu yang");
            System.out.println("memberi tahu jika ingin mengetaahui siapa ayahmu maka kumpulkanlah banyak");
            System.out.println("pokemon");
            Battle.waitAndClear();
            System.out.println("Dikarenakan kamu ingin mengenal ayahmu akhirnya kamu mengiyakan ajakan sang trainer.");
        }

        if(dayCounter == 1 && currentLocation.equals("Rumah")){
            System.out.println("Digga :  ");
            System.out.println("Selamat datang wahai Traveler. Saat ini kita memiliki tugas besar untuk menagkap");
            System.out.println("12 pokemon yang ada untuk mengalahkan raja pokemon yang akan datang dalam 14 hari");
            System.out.println("lagi.");
            Battle.waitAndClear();
            System.out.println("Traveller : ");
            System.out.println("Sepertinya ini tugas yang sangat berat.... Tapi, baiklah akan saya coba untuk mengangkap");
            System.out.println("12 pokemon kurang dari 14 hari.");
            Battle.waitAndClear();
            System.out.println("Digga : ");
            System.out.println("Di hari pertama ini, saya akan memberikan kamu petunjuk untuk cara menangkap pokemon yang ");
            System.out.println("benar");
            Battle.waitAndClear();
            System.out.println("Traveller : ");
            System.out.println("Mohon bantuannya...........");
            Battle.waitAndClear();
            System.out.println("Digga : ");
            System.out.println("Kamu bisa menjelajahi Hutan, Gurun Pasir, Pegunungan dan Sungai untuk memburu pokemon-pokemon");
            System.out.println("ada. Disetiap tempat tersebut akan ada selalu satu pokemon yang bisa kita lawan dan ambil.");
            System.out.println("Setelahnya, ketika kita berhasil mendapatkan semua pokemon di setiap tempat pada hari itu, maka");
            System.out.println("ktia bisa kembali ke rumah untuk beristirahat atau kita bisa Ascend pokemon yang kita miliki");
            System.out.println("agar menjadi lebih kuat untuk melawan pokemon-pokemon selanjutnya. Setelah beristirahat, maka");
            System.out.println("akan ada pokemon-pokemon baru yang akan respawn di tempat-tempat yang kita kunjungi hari yang lalu.");
            System.out.println("Tugas kita adalah membuat strategi agar bisa melawan semua pokemon setiap harinya dan memenangkan pertarungannya.");
            System.out.println("Lakukan setiap hari sebelum hari ke 14 tiba!!!!!");
            Battle.waitAndClear();
            System.out.println("Traveller : ");
            System.out.println("Baiklah....terima kasih atas petunjukunya");
            Battle.waitAndClear();
        }else if(dayCounter == 2){
            System.out.println("Digga : ");
            System.out.println("Selamat, Traveler. kamu telah menjalani hari pertamamu dengan baik.");
            System.out.println("Kamu telah ke mengumpulkan pokemon dari hutan, gunung dan sungai dan Ascend pokemon yang kamu miliki");
            System.out.println("hari ini dan selanjutnya kamu akan tetap menjelajahi banyak tempat dan mencoba melawan banyak pokemon");
            System.out.println("yang lebih kuat dan mencoba menanngkap mereka");
            Battle.waitAndClear();
            System.out.println("Traveller :");
            System.out.println("baiklah, cukup sulit ternyata. aku kira bakal mudah :v");
            Battle.waitAndClear();
            System.out.println("Digga : ");
            System.out.println("Oh iya. jangan lupa untuk selalu melevel up pokemonmu. karena selanjutnya tantangannya akan lebih sulit.");
            Battle.waitAndClear();
            System.out.println("Traveller : ");
            System.out.println("alamak...");
        }else if(dayCounter == 4){
            System.out.println("Digga : ");
            System.out.println("Bagaimana, Traveler apakah kamu sudah mengumpulkan banyak pokemon? oh iya aku ingat kalau");
            System.out.println("sedang mencari-cari ayahmu juga kan.");
            Battle.waitAndClear();
            System.out.println("Traveller : ");
            System.out.println("Iya, sih. ibuku berpesan kalau untuk mengetahui siapa ayahku maka aku harus mengumpulkan banyak");
            System.out.println("pokemon. aku tidak mengerti apa maksudnya");
            Battle.waitAndClear();
            System.out.println("Digga : ");
            System.out.println("hhhmmmppp...mungkinkah..");
            Battle.waitAndClear();
            System.out.println("Traveller : ");
            System.out.println("...Apakah kamu tahu sesuatu?");
            Battle.waitAndClear();
            System.out.println("Digga : ");
            System.out.println("Ntah lah. aku merasa aku tau sesuatu tapi aku lupa. oh iya. jangan berhenti untuk mengumpulkan");
            System.out.println("pokemon karena kelompok aneh tersebut sudah berhasil menangkap sebagian pokemon");

        }else if(dayCounter == 7){
            System.out.println("Traveller : ");
            System.out.println("Digga, apa yang sebenarnya kelompok aneh cari dengan mengumpulkan seluruh pokemon?");
            Battle.waitAndClear();
            System.out.println("Digga : ");
            System.out.println("Mereke ingin memanggil Dewa Pokemon. Jadi Dewa Pokemon adalah pokemon yang memiliki kekuatan luar biasa");
            System.out.println("yang bisa menghancurkan, memanipulasi, menguasai banyak elemen. Pokemon ini adalah makhluk kuno yang menjadi");
            System.out.println("sumber kekuatan para pokemon-pokemon yang ada saat ini. tentunya makhluk ini memmecahkan kekuatannya yang menjadikan");
            System.out.println("pokemon yang kita kenal ada. Dengan mengumpulkan seluruh pokemon mereka akan berencana menggunakan kekuatan");
            System.out.println("Dewa Pokemon untuk menguasai dunia.");

        }else if(dayCounter == 12){
            System.out.println("Digga : ");
            System.out.println("Bagus, kamu sudah sampai sejauh ini. Nasib dunia dan para pokemon ada di tanganmu.");
            System.out.println("Mereka, kelompok aneh itu, juga sudah hampir mencapai target mereka.");
            System.out.println("Engkau pasti bisa melakukannya menyelamatkan para pokemon, dunia, dan menemukan siapa ayahmu");
        }
    }

    public static boolean checkNPC(int dayCounter, String currentLoaction){
        if(dayCounter == 1 && currentLoaction.equals("Rumah")){
            return true;
        }else if(dayCounter == 2 && currentLoaction.equals("Rumah")){
            return true;
        }else if(dayCounter == 4 && currentLoaction.equals("Rumah")){
            return true;
        }else if(dayCounter == 7 && currentLoaction.equals("Rumah")){
            return true;
        }else if(dayCounter == 12 && currentLoaction.equals("Rumah")){
            return true;
        }else{
            return false;
        }
    }
}
