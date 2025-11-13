import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Informe uma quantidade de participantes de 1 à 20: ");
        int amountOfParticipants = Integer.parseInt(scan.nextLine());

        ControleTeleSena controller = createGame(amountOfParticipants);

        controller.startRaffle();
    }

    public static ControleTeleSena createGame(int amountParticipants) {
        if (amountParticipants <= 0 || amountParticipants > 20 ) throw new Error("Vai te catar meu");

        ControleTeleSena controller = new ControleTeleSena();

        ArrayList<String> names = new ArrayList<>();

        names.add("Aeronauta Barata");
        names.add("Agrícola Beterraba Areia");
        names.add("Agrícola da Terra Fonseca");
        names.add("Alce Barbuda");
        names.add("Amado Amoroso");
        names.add("Amável Pinto");
        names.add("Amazonas Rio do Brasil Pimpão");
        names.add("América do Sul Brasil de Santana");
        names.add("Amin Amou Amado");
        names.add("Antonio Manso Pacífico de Oliveira Sossegado");
        names.add("Antônio Morrendo das Dores");
        names.add("Aricléia Café Chá");
        names.add("Asteróide Silverio");
        names.add("Ava Gina");
        names.add("Bandeirante do Brasil Paulistano");
        names.add("Barrigudinha Seleida");
        names.add("Bispo de Paris");
        names.add("Bizarro Assada");
        names.add("Céu Azul do Sol Poente");
        names.add("Chevrolet da Silva Ford");
        names.add("Colápso Cardíaco da Silva");
        names.add("Disney Chaplin Milhomem da Silva");
        names.add("Dezêncio Feverêncio de Oitenta e Cinco");
        names.add("Dolores Fuertes de Barriga");
        names.add("Esparadrapo Clemente de Sá");
        names.add("Homem Bom da Cunha Souto Maior");
        names.add("Ilegível Inilegível");
        names.add("Inocêncio Coitadinho");
        names.add("Janeiro Fevereiro de Março Abril");
        names.add("Lança Perfume Rodometálico de Andrade");
        names.add("Marciano Verdinho das Antenas Longas");
        names.add("Maria Privada de Jesus");
        names.add("Maria Tributina Prostituta Cataerva");
        names.add("Maria-você-me-mata");
        names.add("Mimaré Índio Brazileiro de Campos");
        names.add("Napoleão Sem Medo e Sem Mácula");
        names.add("Natal Carnaval");
        names.add("Necrotério Pereira da Silva");
        names.add("Oceâno Atlântico Linhares");
        names.add("Otávio Bundasseca");
        names.add("Pacífico Armando Guerra");
        names.add("Padre Filho do Espírito Santo Amém");
        names.add("Plácido e Seus Companheiros");
        names.add("Remédio Amargo");
        names.add("Renato Pordeus Furtado");
        names.add("Restos Mortais de Catarina");
        names.add("Rocambole Simionato");
        names.add("Universo Cândido");
        names.add("Vicente Mais ou Menos de Souza");
        names.add("Zélia Tocafundo Pinto");

        Pessoa[] selectedParticipants = new Pessoa[amountParticipants];

        for(int i = 0; i < amountParticipants; i++) {
            int randomNumber = (int)(Math.random() * (names.size() - i));
            selectedParticipants[i] = new Pessoa(names.get(randomNumber + 1 ));
            names.remove(randomNumber);

//            int amountOfTelesenas = (int)(Math.random() * 15 + 1);
            int amountOfTelesenas = 15;

            controller.buyTelesena(selectedParticipants[i], amountOfTelesenas);
        }

        return controller;
    }
}