package com.syukri.uaspbo.menu;

import com.syukri.uaspbo.Battle;
import com.syukri.uaspbo.PlayersMonsters;

public class GuideNPC {
    public static void conversation(int dayCounter, String currentLocation){
        Explore objekDay = new Explore(null, null);
        PlayersMonsters myDeck = new PlayersMonsters();
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
            objekDay.dayCounter++;
        }

        if(dayCounter == 1 && currentLocation.equals("Rumah")){
            System.out.println("Digga :  ");
            System.out.println("Selamat datang wahai Traveler. Saat ini kita memiliki tugas besar untuk menagkap");
            System.out.println("12 pokemon yang ada untuk mengalahkan raja pokemon yang akan datang dalam 14 hari");
            System.out.println("lagi.");
            Battle.waitAndClear();
            System.out.println("Traveler : ");
            System.out.println("Sepertinya ini tugas yang sangat berat.... Tapi, baiklah akan saya coba untuk mengangkap");
            System.out.println("12 pokemon kurang dari 14 hari.");
            Battle.waitAndClear();
            System.out.println("Digga : ");
            System.out.println("Di hari pertama ini, saya akan memberikan kamu petunjuk untuk cara menangkap pokemon yang ");
            System.out.println("benar");
            Battle.waitAndClear();
            System.out.println("Traveler : ");
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
            System.out.println("Traveler : ");
            System.out.println("Baiklah....terima kasih atas petunjukunya");
            Battle.waitAndClear();
        }else if(dayCounter == 2){
            
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
