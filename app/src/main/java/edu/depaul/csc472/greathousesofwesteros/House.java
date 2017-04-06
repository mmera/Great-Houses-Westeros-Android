package edu.depaul.csc472.greathousesofwesteros;

/**
 * Created by Marco on 10/29/16.
 */

public class House {

    private String name;
    private String motto;
    private String history;
    private NotableMember[] notableMembers;

    public House(String name, String motto,
                 String history,NotableMember[] notableMembers){
        this.name = name;
        this.motto = motto;
        this.history = history;
        this.notableMembers = notableMembers;

    }

    public String getMotto() {
        return motto;
    }


    public String getName() {
        return name;
    }


    public String getHistory() {
        return history;
    }


    public NotableMember[] getNotableMembers() {
        return notableMembers;
    }

    public String toString(){
        return this.name;
    }

    public static int getIconResource(String name) {
        switch (name) {
            case "Stark": return R.drawable.stark;
            case "Lannister":  return R.drawable.lannister;
            case "Bolton": return R.drawable.bolton;
            case "Arryn": return R.drawable.arryn;
            case "Martell": return R.drawable.martell;
            case "Hightower": return R.drawable.hightower;
            case "Tyrell": return R.drawable.tyrell;
            case "Tully": return R.drawable.tully;
            case "Targaryen": return R.drawable.targaryen;
            case "Royce":return R.drawable.royce;
            case "Redwyne": return R.drawable.redwyne;
            case "Greyjoy":return R.drawable.greyjoy;
            case "Yronwood":return R.drawable.yronwood;
            case "Baratheon": return R.drawable.baratheon;

        }
        return -1;
    }



}
