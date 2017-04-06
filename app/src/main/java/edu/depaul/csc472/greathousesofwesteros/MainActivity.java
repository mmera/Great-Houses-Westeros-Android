
package edu.depaul.csc472.greathousesofwesteros;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActionBar();
        setListAdapter(new HouseAdapter());
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent intent = new Intent(MainActivity.this, HouseActivity.class);
        intent.putExtra("HouseName", HOUSES[position].getName());
        intent.putExtra("HouseHistory", HOUSES[position].getHistory());
        intent.putExtra("Sigil", House.getIconResource(HOUSES[position].getName()));
        ArrayList<NotableMember> notableMembers = new ArrayList<NotableMember>(Arrays.asList(HOUSES[position].getNotableMembers()));
        intent.putParcelableArrayListExtra("Members",notableMembers);
        startActivity(intent);
    }


    class HouseAdapter extends BaseAdapter {

        private LayoutInflater inflater;

        @Override
        public int getCount() {
            return HOUSES.length;
        }

        @Override
        public Object getItem(int i) {
            return HOUSES[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            if (convertView == null) {
                if (inflater == null)
                    inflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                row = inflater.inflate(R.layout.list_layout, parent, false);
            }

            ImageView icon = (ImageView) row.findViewById(R.id.sigil);
            TextView name = (TextView) row.findViewById(R.id.house_name);
            TextView motto = (TextView) row.findViewById(R.id.motto);

            House h = HOUSES[position];
            name.setText("House " + h.getName());
            motto.setText("\"" + h.getMotto() + "\"");
            icon.setImageResource(House.getIconResource(h.getName()));
            return row;
        }
    }

    public static final House[] HOUSES = {

            new House("Stark",
                    "Winter is Coming",
                    "House Stark of Winterfell is one of the Great Houses of Westeros and the principal noble house of the north; many lesser houses are sworn to them. In days of old they ruled as Kings of Winter, but since the Wars of Conquest by House Targaryen they have been Wardens of the North. Their seat, Winterfell, is an ancient castle renowned for its strength.",
                    new NotableMember[]{
                            new NotableMember("Brandon Stark",
                                    "According to legend, Brandon built the Wall and Winterfell; some stories say he did this with the help of giants. Tales from the stormlands claim Brandon helped Durran build Storm's End when he was a boy. Some stories claim King Uthor of the High Tower commissioned Bran to design the stone Hightower at Oldtown, while others state it was Bran's son, who was also named Brandon."),
                            new NotableMember("Eddard Stark",
                                    "Eddard Stark, also called \"Ned\", was the head of House Stark, Lord of Winterfell, and Warden of the North. He was a close friend to King Robert I Baratheon, with whom he was raised. Eddard is known for his unwavering sense of honor and justice and his family finds him kind, although some consider his reserved personality a sign of coldness and disdain."),
                            new NotableMember("Robb Stark", "Robb Stark is the eldest son of Eddard Stark and Catelyn Tully and is the heir of House Stark to Winterfell and the north. He is called the Young Wolf by friend and foe alike. Upon Eddard's execution in King's Landing at the command of King Joffrey, effectively ending the possibility of peace between Stark and Lannister, Robb is crowned at Riverrun by his bannermen and the river lords as the King in the North.")}),

            new House("Targaryen",
                    "Fire and Blood",
                    "House Targaryen is a noble family of Valyrian descent that escaped the Doom. They lived for centuries on the island of Dragonstone until Aegon the Conqueror and his sisters rode their dragons in their conquest of the Seven Kingdoms.",
                    new NotableMember[]{
                            new NotableMember("Aegon Targaryen", "Aegon I Targaryen, also known as Aegon the Conqueror and Aegon the Dragon, was the first Lord of the Seven Kingdoms and king on the Iron Throne, having conquered six of the Seven Kingdoms during the Conquest. He was the founder of the ruling Targaryen dynasty of Westeros."),
                            new NotableMember("Aerys II Targaryen", "Aerys II Targaryen, also called the Mad King and King Scab, was the seventeenth and last member of the Targaryen dynasty to sit the Iron Throne, ruling from 262 AC to 283 AC. Aerys showed great promise at the start of his reign, bringing peace and prosperity to the Seven Kingdoms, but later descended into insanity."),
                            new NotableMember("Daenerys Targaryen", "Princess Daenerys Targaryen, known as Daenerys Stormborn,is one of the last confirmed members of House Targaryen. Although she has matured enough to recognize that her older brother Viserys was weak, cowardly and cruel, his abiding obsession with regaining the crown he felt was his birthright has instilled in Daenerys a similar belief that reclaiming the Seven Kingdoms is both her right and her duty as the last of the Targaryens, and it remains the paramount goal of her life. ")}),

            new House("Lannister",
                    "Hear Me Roar",
                    "House Lannister of Casterly Rock is one of the Great Houses of Seven Kingdoms, and the principal house of the westerlands. Their seat is Casterly Rock, though another branch exists that is based in nearby Lannisport. The Warden of the West is a Lannister by tradition.",
                    new NotableMember[]{
                            new NotableMember("Lan Lannister", "Lann the Clever is the legendary hero from the Age of Heroes that founded House Lannister.One popular story tells how he supposedly swindled Casterly Rock from the Casterlys using nothing but his wits. In another tale he is said to have stolen gold from the sun to brighten his hair."),
                            new NotableMember("Tywin Lannister", "Tywin Lannister is Lord of Casterly Rock, Shield of Lannisport, and Warden of the West. The head of House Lannister, Tywin is one of the most powerful lords in Westeros, and is the father of Jaime, Cersei, and Tyrion Lannister. Tywin is a calculating, intelligent, politically astute, ruthless, and controlling man. He dedicates his life and efforts towards maintaining the Lannisters' prestige, and ensuring House Lannister is respected, or at least feared."),
                            new NotableMember("Jaime Lannister", "Ser Jaime Lannister, also known as the Kingslayer, is a knight from House Lannister. He is the second child and first-born son of Lord Tywin Lannister of Casterly Rock and his wife, Lady Joanna, also of House Lannister. He is the twin brother of Queen Cersei Lannister. Raised at the age of fifteen to the Kingsguard of the Mad King, Aerys II Targaryen, Jaime became the youngest member in the history of the prestigious knightly order.[3] He earned the derogatory nickname \"Kingslayer\" when he treasonously slew Aerys near the end of Robert's Rebellion.")}),

            new House("Martell",
                    "Unbowed, Unbent, Unbroken",
                    "House Nymeros Martell of Sunspear is one of the Great Houses of Westeros and is the ruling house of Dorne. 'Nymeros' indicates \"of the line of Nymeria,\" but generally it is simply called House Martell. The seat of the Prince of Dorne is Sunspear in southeastern Dorne.",
                    new NotableMember[]{
                            new NotableMember("Oberyn Martell", "Prince Oberyn Nymeros Martell, known as the Red Viper, is a member of House Martell and is Prince Doran's hot-headed younger brother. Oberyn is an exceptional fighter, his speed and skill with both spear and sword are renowned."),
                            new NotableMember("Morgan Martell", "Morgan Martell was an Andal adventurer and the founder of House Martell. "),
                            new NotableMember("Doran Martell", "Prince Doran Nymeros Martell, also known simply as Doran Martell, is the head of House Martell, the Prince of Dorne, and the Lord of Sunspear.Unlike Oberyn, Doran is a cautious, pensive, and subtle man. He is prone to think long on the matters before him, weighing every word and every action.")}),

            new House("Tyrell",
                    "Growing Strong",
                    "House Tyrell of Highgarden is one of the Great Houses of the Seven Kingdoms, being Lords Paramount of the Mander and the liege lords of the Reach. A large, wealthy house, its wealth is only surpassed among the Great Houses by House Lannister, and the Tyrells can field the greatest armies. Additionally, if they call the ships of the Redwyne fleet, the lords of the Shield Islands, and the coastal lords, they can command a navy that equals if not surpasses the royal fleet of King's Landing.",
                    new NotableMember[]{
                            new NotableMember("Alester Tyrell", "Ser Alester Tyrell was an Andal knight and adventurer who founded House Tyrell."),
                            new NotableMember("Loras Tyrell", "Ser Loras Tyrell is a knight of House Tyrell and the third son of Lord Mace Tyrell. Known as the Knight of Flowers, he is a highly skilled knight and jouster. His tournament successes, dazzling good looks, and ostentatious showmanship have made him a celebrated figure in the courts of the Seven Kingdoms. "),
                            new NotableMember("Margaery Tyrell", "Margaery is Queen of the Seven Kingdoms through marriage to King Joeffrey Baratheon and later King Tommen Baratheon. Margaery is an intelligent, shrewd and politically savvy young woman, very much the protégée of her cunning grandmother, Lady Olenna Redwyne.")}),

            new House("Baratheon",
                    "Ours is the Fury",
                    "House Baratheon of Storm's End is one of the Great Houses of Westeros, and is the principal house in the stormlands, which they rule as Lords Paramount of the Stormlands. Their seat, Storm's End, is an ancient castle raised by the Storm Kings from the now-extinct House Durrandon. The Baratheon sigil is a crowned black stag on a field of gold. Members of the family tend to be tall and powerfully built, with black hair and blue eyes, as well as strong, square jawlines. They are known for their mercurial tempers.",
                    new NotableMember[]{
                            new NotableMember("Orys Baratheon", "Orys Baratheon, known as Orys One-Hand, was the founder of House Baratheon and was the first Lord of Storm's End after House Durrandon.He slew the last Storm King, Argilac the Arrogant, married his daughter Argella, and became the first Lord Paramount of the Stormlands. Orys is also considered the first Hand of the King, serving Aegon the Conqueror."),
                            new NotableMember("Robert Baratheon", "King Robert I Baratheon is the Lord of the Seven Kingdoms of Westeros and the head of House Baratheon of King's Landing. Robert was crowned king after winning the rebellion which was named after him and taking the Iron Throne from King Aerys II Targaryen, his first cousin once removed. Robert fought the war to win back his betrothed, Lyanna Stark, with the aid of her brother, his close friend, Lord Eddard Stark."),
                            new NotableMember("Joffrey Baratheon", "Prince Joffrey Baratheon is known to the Seven Kingdoms as the eldest son and heir of King Robert I Baratheon and Queen Cersei Lannister. Despite being willful he is reckless, vicious, cruel and not very intelligent, all of which combine to make him prone to irrational and bad judgements. ")}),

            new House("Tully",
                    "Family, Duty, Honor",
                    "House Tully of Riverrun is one of the Great Houses of the Seven Kingdoms. Lord Hoster Tully, the Lord Paramount of the Trident, rules over the riverlands from the Tully seat of Riverrun. Members of the family tend to have auburn hair, high cheekbones, and bright blue eyes.",
                    new NotableMember[]{
                            new NotableMember("Brynden Tully", "Ser Brynden Tully, also known as Brynden Blackfish or simply the Blackfish, is a knight from House Tully. He is the younger brother of Lord Hoster Tully. He is a seasoned and renowned warrior, a veteran of half a hundred battles, and Knight of the Gate."),
                    }),

            new House("Arryn",
                    "As High As Honor"
                    , "House Arryn of the Eyrie is one of the Great Houses of Westeros, and is the principal noble house in the Vale of Arryn. Their main seat is the Eyrie, which is considered impregnable.However, House Arryn has at least one other holding, their winter castle at the Gates of the Moon, which was once their main seat. Both of these fortifications sit astride the Giant's Lance, the tallest mountain in the Vale, the Gates of the Moon at its foot, the Eyrie at its top.",
                    new NotableMember[]{
                            new NotableMember("Artys I Arryn", "Artys I Arryn was the first King of Mountain and Vale and the founder of House Arryn in Westeros.Prior to his coronation, Ser Artys, called the Falcon Knight, was an Andal knight who defeated the First Men of the Vale in the Battle of the Seven Stars."),
                            new NotableMember("Jon Arryn", "Jon Arryn was a head of House Arryn whose titles included Lord of the Eyrie, Defender of the Vale, and Warden of the East. He served as Hand of the King to Robert I Baratheon from 283 AC until his unexpected death in 298 AC.")}),

            new House("Greyjoy",
                    "We Do Not Sow",
                    "House Greyjoy of Pyke is one of the Great Houses of Westeros. It rules over the Iron Islands, a harsh and bleak collection of forbidding islands off the west coast of Westeros, from the Seastone Chair in the castle of Pyke on the island of the same name. The head of the family is traditionally known as the Lord Reaper of Pyke.",
                    new NotableMember[]{
                            new NotableMember("Theon Greyjoy", "Theon Greyjoy is a member of House Greyjoy and is the sole surviving son and heir apparent of Lord Balon Greyjoy. At the end of the Greyjoy Rebellion, Theon was taken as a hostage and ward to Lord Eddard Stark."),
                            new NotableMember("Euron Greyjoy", "Euron Greyjoy, known as Crow's Eye[2] and Euron Crow's Eye, is a member of House Greyjoy and is the eldest of Lord Balon Greyjoy's younger brothers. Euron is captain of the Silence, a ship crewed entirely by mutes whose tongues he ripped out. Euron's personal coat-of-arms is a red eye with a black pupil beneath a black iron crown supported by two crows."),
                            new NotableMember("Yara Greyjoy", "Yara Greyjoy is a member of House Greyjoy and is the daughter of Lord Balon Greyjoy by his wife, Alannys Harlaw. Asha is fierce and proud, and defies traditional ironborn gender roles by commanding her own ship, the Black Wind, and leading men into battle.")}),

            new House("Hightower",
                    "We Light the Way",
                    "House Hightower of the Hightower is one of the most important and powerful vassals of House Tyrell (and before them of House Gardener). Their seat is the Hightower in the city of Oldtown within the Reach. The Hightowers are among the oldest and proudest of the Great Houses.",
                    new NotableMember[]{
                            new NotableMember("Gerold Hightower", "Ser Gerold Hightower, known as the White Bull, was the Lord Commander of the Kingsguard during the reigns of Kings Jaehaerys II Targaryen and Aerys II Targaryen."),
                            new NotableMember("Uthor of the Hightower", "Uthor is credited with commissioning Bran the Builder or his son Brandon Stark to rebuild the Hightower, turning it from a tall timber tower and a beacon to a structure of stone that rose two hundred feet above the Whispering Sound.")}),

            new House("Royce",
                    "We Remember",
                    "House Royce of Runestone is an old and powerful noble house of the Vale, sworn to House Arryn. Their seat is the ancestral castle Runestone, located on the coast of the narrow sea north of Gulltown. There is a cadet branch occupying the non-hereditary seat of the Gates of the Moon, located on the path that leads to the Eyrie.",
                    new NotableMember[]{
                            new NotableMember("Yorwyck VI Royce", "King Yorwyck VI Royce was a Bronze King of House Royce of Runestone who lived during the Andal invasion. He claimed the Runic Crown when his sire died in battle against House Shett."),
                            new NotableMember("Robar II Royce", "High King Robar II Royce was the last Bronze King of House Royce of Runestone, who lived during the Andal invasion. He was the grandson of Yorwyck VI Royce. He united much of the Vale under his rule as Robar Royce, Second of That Name, High King of the Vale, the Fingers, and the Mountains of the Moon.")}),

            new House("Yronwood",
                    "We Guard the Way",
                    "House Yronwood of Yronwood is the most powerful house in Dorne after the Martells. Yronwood Castle is the last fortress defending the Boneway; this is reflected in their title Warden of the Stone Way.The Yronwoods were kings in Dorne before the arrival of the Rhoynar; the head of the house continues to hold the title The Bloodroyal.",
                    new NotableMember[]{
                            new NotableMember("Yorick V Yronwood", "Yorick was the richest and most powerful of the Dornish kings at the start of Nymeria's War. Yorick's supporters included his bannermen, the Jordaynes and the Wyls, as well as the Blackmonts and Qorgyles. Yorick himself slew Nymeria's spouse, Prince Mors Martell, in the Third Battle of the Boneway. ")})

    };
}