package com.deeppsy.psychologyfacts;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
/*
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.InterstitialAd;
*/
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Objects;

public class FactOfTheDayActivity extends AppCompatActivity {
    static int a = 1;

    ArrayList<FactData> list;

    ArrayList<FavData> mFavData;

    int position;
    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(DetailAdapterForAllFacts.SHARED_FAV, 0);

        ArrayList<FavData> arrayList = (new Gson()).fromJson(sharedPreferences.getString(DetailAdapterForAllFacts.FAV_DATA, null), (new TypeToken<ArrayList<FavData>>() {

        }).getType());
        this.mFavData = arrayList;
        if (arrayList == null)
            this.mFavData = new ArrayList<>();
    }

    private void saveData() {
        SharedPreferences.Editor editor = getSharedPreferences(DetailAdapterForAllFacts.SHARED_FAV, 0).edit();
        String str = (new Gson()).toJson(this.mFavData);
        editor.putString(DetailAdapterForAllFacts.FAV_DATA, str);
        editor.apply();
    }
    protected void onCreate(Bundle paramBundle) {
        boolean z = false;
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_fact_of_the_day);
        getWindow().setStatusBarColor(getColor(R.color.colorPrimary));
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Fact of Day");
        setSupportActionBar(toolbar);
        ((ActionBar) Objects.requireNonNull(getSupportActionBar())).setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBar actionBar = getSupportActionBar();
        boolean bool2 = false;
        actionBar.setDisplayShowTitleEnabled(false);
        ArrayList<FactData> arrayList = new ArrayList<FactData>();
        this.list = arrayList;
        arrayList.add(new FactData("The older you get, the less people you trust.\n"));
        this.list.add(new FactData("Young children learn about prejudice by instruction, older children by experience.\n"));
        this.list.add(new FactData("Whenever a person seems to be hiding something while talking to you, don’t ask them again and again. Just look in their eyes. The prolonged eye contact will make them feel too uncomfortable and guilty to lie to you, and they will tell the truth.\n"));
        this.list.add(new FactData("The relation between your thumb and your nose is - the length of your thumb is equal to the length of your nose."));
        this.list.add(new FactData("Females are better at multitasking than males.\n"));
        this.list.add(new FactData("Anger increases the desire of possession in people.  They make more efforts to obtain the object that is associated with angry faces."));
        this.list.add(new FactData("You can use anger to convert feelings of vulnerability and helplessness into feelings of control and power."));
        this.list.add(new FactData("Anger is a social emotion. You always have a target that your anger is directed against (even if that target is yourself). Feelings of pain, combined with anger-triggering thoughts motivate you to take action, face threats and defend yourself by striking out against the target you think is causing you pain."));
        this.list.add(new FactData("Some people develop an unconscious habit of transforming almost all of their vulnerable feelings into anger so they can avoid having to deal with them."));
        this.list.add(new FactData("\nHowever, angry people think about harming those who have caused pain. Part of the transmutation of pain into anger involves an attention shift - from self-focus to other-focus.\n"));
        this.list.add(new FactData("Listen carefully to how a person speaks to you about other people. That is exactly how they will speak about you to other people.\n"));
        this.list.add(new FactData("Happier people are more likely to retain relationships.\n"));
        this.list.add(new FactData("If someone is always angry at you just stay calm. It will help them to be ashamed later."));
        this.list.add(new FactData("Meanwhile, men who were told they had high testosterone levels were more likely to support gender equality and more likely to engage in stereotypically feminine behaviours, like caretaking or doing housework and don't show aggression easily.\n"));
        this.list.add(new FactData("Anger is an emotion characterized by antagonism toward someone or something you feel has deliberately done you wrong.\n"));
        this.list.add(new FactData("It is impossible to remain angry at someone you truly love. Anger lasting for more than three days indicates that you’re not in love.\n"));
        this.list.add(new FactData("Negative emotions such as anxiety and fear are more common in dreams.\n"));
        this.list.add(new FactData("Women are said to have slightly longer dreams than man.\n"));
        this.list.add(new FactData("Before colour TV, 75% of people were dreaming in black and white. \n"));
        this.list.add(new FactData(" Babies don't dream of themselves until they reach at the age of 3.\n"));
        this.list.add(new FactData(" Our body burns more calories during sleeping than it does in the day time.\n"));
        this.list.add(new FactData("Men get erection in REM sleep.\n"));
        this.list.add(new FactData("In every girl’s life, there’s a boy she’ll never forget. In every boy’s life, there’s a girl he can never get.\n"));
        this.list.add(new FactData("Girls don't like being stared at, unless they are already staring at you.\n"));
        this.list.add(new FactData("Women cheat in a much better way and have their reasons (men just do it and can't explain it when get caught)\n"));
        this.list.add(new FactData("Women are less attracted to men who have a belly (this one might be a bit obvious). A large amount of abdominal fat on an individual indicates that they have lower levels of testosterone!\n"));
        this.list.add(new FactData("When a woman is attracted to a man, she speaks on a higher pitch than normal.\n"));
        String str = "When you shiver in the cold, your body releases the exercise hormone irisin, which encourages your body to turn fat into heat.\n";
        this.list.add(new FactData(str));
        String str2 = "The Interaction Between Genes and Certain Environmental Factors Can Influence How a Child Develops during pregnancy.\n";
        this.list.add(new FactData(str2));
        String str3 = "When you sneeze, your tissues die for a milli second.\n";
        this.list.add(new FactData(str3));
        this.list.add(new FactData("If you ask someone a question and they only partially answer just wait and stay silent, they will usually continue talking.\n"));
        this.list.add(new FactData("Creativity is intelligence having fun - Albert Einstein\n"));
        this.list.add(new FactData("The harder you work for something, the greater you'll feel when you finally achieve it.\n"));
        this.list.add(new FactData("Don't be afraid to do something just because you're scared of what people are going to say about you. People will judge you no matter what.\n"));
        this.list.add(new FactData("People have limitations, especially when it comes to learning.\n"));
        this.list.add(new FactData("If you suspect someone is following you, take four right turns. If they're still behind you, they're following you.\n"));
        this.list.add(new FactData("Travel as much as you can. As far as you can. As long as you can. Life’s not meant to be lived in one place.\n"));
        this.list.add(new FactData("After eating too much, your hearing is less sharp\n"));
        String str4 = "Humans are the only animals who express shock and surprise by their mouths dropping open.\n";
        this.list.add(new FactData(str4));
        String str5 = "An individual blood cell takes about 60 seconds to make a complete circuit of the body.\n";
        this.list.add(new FactData(str5));
        String str6 = "A human’s ears and nose never stop growing.\n";
        this.list.add(new FactData(str6));
        String str7 = "If a human being’s DNA were uncoiled, it would stretch 10 billion miles, from Earth to Pluto and back. \n";
        this.list.add(new FactData(str7));
        String str8 = "A human skeleton renews itself completely every 10 years.\n";
        this.list.add(new FactData(str8));
        String str9 = "Bone is five times stronger than a steel bar of the same width, but it is brittle and can fracture on impact.";
        this.list.add(new FactData(str9));
        String str10 = "The body can detect taste in .0015 seconds, which is faster than the blink of an eye.\n";
        this.list.add(new FactData(str10));
        String str11 = "Like fingerprints, each human tongue has its own unique print.\n";
        this.list.add(new FactData(str11));
        String str12 = "Ophiophobia is the fear of the navel.\n";
        this.list.add(new FactData(str12));
        String str13 = str2;
        String str14 = "Humans spend about five years of their lives eating.\n";
        this.list.add(new FactData(str14));
        String str15 = str;
        String str16 = "A human eye can distinguish between approximately 10 million different colours.\n";
        this.list.add(new FactData(str16));
        String str17 = str16;
        String str18 = "A person suffering from anosmia is unable to detect smells.\n";
        this.list.add(new FactData(str18));
        String str19 = str18;
        String str20 = "The average person passes gas about 15 times a day. Most people try to do it privately, but kids (of all ages) like to share them with friends and family.\n";
        this.list.add(new FactData(str20));
        String str21 = str20;
        String str22 = "\nFingernails grow about 3 millimetres per month, which is about twice as fast as toenails.\n";
        this.list.add(new FactData(str22));
        String str23 = str22;
        String str24 = "Some people can hear their eyeballs moving around in their head.\n";
        this.list.add(new FactData(str24));
        String str25 = str14;
        this.list.add(new FactData("The placebo effect is becoming more powerful over time. As medical technology improves, our faith in medicine becomes stronger.\n"));
        this.list.add(new FactData("Natural clones, also known as identical twins, occur in humans and other mammals. These twins are produced when a fertilized egg splits, creating two or more embryos that carry almost identical DNA.\n"));
        this.list.add(new FactData("Narcissistic Personality Disorder often co-exists with depression or anxiety, which is typically the only reason a narcissist tries therapy.\n"));
        this.list.add(new FactData("Witzelsucht is a mental disorder that causes the sufferer to compulsively make inappropriate puns or jokes and tell pointless stories.\n"));
        String str26 = "Doing things that scare you will make you happier and a chemical called adrenaline released by the brain is responsible for it.\n";
        this.list.add(new FactData(str26));
        String str27 = str26;
        this.list.add(new FactData("Feeling butterflies in your belly when you fall for someone is real and it is because of the adrenaline rush you experience as the body’s response to a fight-or-flight situation.\n"));
        this.list.add(new FactData("For a man’s mental health, a 5-minute conversation with a beautiful girl is more beneficial than a 2-hour yoga.\n"));
        this.list.add(new FactData("There is enough DNA in an average person’s body to stretch from the sun to Pluto and back — 17 times. \n"));
        this.list.add(new FactData(str3));
        String str28 = "Our bone marrow produces 260 billion red blood cells (RBCs) and 135 billion white blood cells (WBCs) per day.\n";
        this.list.add(new FactData(str28));
        this.list.add(new FactData("The same skin cells that make up a human vagina are the same type of cells that are in a human mouth.\n"));
        this.list.add(new FactData("You can't hum while holding or pressing your both side of nose tightly. If you will try this you will feel unconscious in short period of time.\n"));
        this.list.add(new FactData("There are more bacteria in a human mouth than there are people in the world.\n"));
        this.list.add(new FactData("During your lifetime, you will produce enough saliva to fill two swimming pools and Your nose can remember 50,000 different scents.\n"));
        this.list.add(new FactData("Closing your eyes helps you remember things. It will stop all other activities and makes your concentration fully on your mind so it is easy to remember or visual that thing easily.\n"));
        this.list.add(new FactData("Each day, our heart produces enough energy to drive a truck for 20 miles.\n"));
        this.list.add(new FactData(str24));
        this.list.add(new FactData("When you do public speaking or giving a presentation use your arms to guide, don’t ever keep it in your pockets or hold it in your back.\n"));
        this.list.add(new FactData("When you shake someone's hand for the first time, make sure they're warm. Warm hands mean a warm approach. Not mind-blowing but a useful technique.\n"));
        this.list.add(new FactData("Presentation Matters. Be it a work presentation or your own appearance, the presentation is an important factor. You should always dress and prepare according to the occasion.\n"));
        this.list.add(new FactData("Tell people your deepest secrets while looking in their eyes. They will feel an instant attraction. (The Science of Attraction)\n"));
        this.list.add(new FactData("At the Handshaking time, If a person takes your wrist with their free hand, they are showing that they can be trusted. This Known as “Glove Handshake\".\n"));
        this.list.add(new FactData("If person is biting the arms of their glasses, that indicates that They are definitely worried about something at a subconscious level.\n"));
        this.list.add(new FactData("When someone put their hands in front of their face with the index finger near the nose, they’re not buying what you say or at least they disagree with you.\n"));
        this.list.add(new FactData("Moving your legs or hands constantly while talking means you're pretty confused and uncomfortable.\n"));
        this.list.add(new FactData(str4));
        this.list.add(new FactData("On average, those who eat with one other person eat about 30 per cent more than they do when they are alone; members of a group of four eat about 40 per cent more; those in groups of seven or more eat 50 per cent more.\n"));
        this.list.add(new FactData("Spending a large amount of time with someone literally causes you to pick up their habits. Choose your friends wisely.\n"));
        this.list.add(new FactData(str28));
        this.list.add(new FactData("The same skin cells that make up a human vagina are the same type of cells that are in a human mouth.\n"));
        this.list.add(new FactData("You can't hum while holding or pressing your both side of nose tightly. If you will try this you will feel unconscious in short period of time.\n"));
        this.list.add(new FactData("There are more bacteria in a human mouth than there are people in the world.\n"));
        this.list.add(new FactData("During your lifetime, you will produce enough saliva to fill two swimming pools and Your nose can remember 50,000 different scents.\n"));
        this.list.add(new FactData("Closing your eyes helps you remember things. It will stop all other activities and makes your concentration fully on your mind so it is easy to remember or visual that thing easily.\n"));
        this.list.add(new FactData(str5));
        this.list.add(new FactData(str6));
        this.list.add(new FactData(str7));
        this.list.add(new FactData(str8));
        this.list.add(new FactData(str9));
        this.list.add(new FactData(str10));
        this.list.add(new FactData(str11));
        this.list.add(new FactData(str12));
        this.list.add(new FactData(str25));
        this.list.add(new FactData(str17));
        this.list.add(new FactData(str19));
        this.list.add(new FactData(str21));
        this.list.add(new FactData(str23));
        this.list.add(new FactData("When talking to somebody, looking anywhere than his face is the most powerful “I'm lame and unconfident” message emitter you can use.\n"));
        this.list.add(new FactData("When you do public speaking or giving a presentation use your arms to guide, don’t ever keep it in your pockets or hold in your back.\n"));
        this.list.add(new FactData("Studies have also shown that people who dress well feel better about themselves and are generally happier.\n"));
        this.list.add(new FactData("Of all the facial expressions, the smile may be the most deceptive. There are around 18 different smiles, but only one, the Duchenne smile, reflects genuine happiness.\n"));
        this.list.add(new FactData("A lioness does 90% of all the hunting in the family. "));
        this.list.add(new FactData("\nA whale's heart is too slow it just beats just nine times per minute. \n"));
        this.list.add(new FactData("Rates can live without water even longer than comes. "));
        this.list.add(new FactData("\nMale dogs raise their leg to pee because they want to aim as high as possible. \n"));
        this.list.add(new FactData("\nAnts have superhuman strength! Ants are ridiculously strong. They have the ability to carry between 10 and 50 times their own body weight! The amount an ant can carry depends on the species. The Asian weaver ant, for deeppsy, can lift 100 times its own mass.\n"));
        this.list.add(new FactData("Ants are as old as dinosaurs, A study from Harvard and Florida State Universities discovered that ants first rose during the Cretaceous period around 130 million years ago!"));
        this.list.add(new FactData("Turtles never die of old age. ANSWER: TRUE. Turtles exhibit what is known as 'negligible senescence.' In other words, unlike humans, they do not continue to age once their bodies reach maturity."));
        this.list.add(new FactData("Horses can sleep both lying down and standing up."));
        this.list.add(new FactData("A horse's teeth take up a larger amount of space in their head than their brain."));
        this.list.add(new FactData("\nCows can see almost 360 degrees. This near-panoramic view lets them watch for predators from all angles.\n"));
        this.list.add(new FactData("Crocodiles Might Literally Sleep with One Eye Open."));
        this.list.add(new FactData("Crocodiles sleeps 17 hours per day."));
        this.list.add(new FactData("We cannot read in dream because dreaming and reading are function of-different side of the brain.\n"));
        this.list.add(new FactData("If you see dirty water in your dream, it is believed that you might have a health issue that your body is trying to communicate to you.\n"));
        this.list.add(new FactData("If you are pregnant and giving birth, it might not be as simple as that you're going to have a baby, but instead, that you are in the process of creating a new idea.\n"));
        this.list.add(new FactData("You can't read in your dream because reading and dreaming or functions are different side of brain, which don't cooperate during dreams.\n"));
        this.list.add(new FactData("If you are falling in your dream usually means you need to regain control.\n"));
        this.list.add(new FactData("Women judge so quickly, and their judgment rarely goes wrong\n"));
        this.list.add(new FactData("More successful and rich people are considered to be more intelligent and wiser, and vice versa. Often, people tend to think that those who are successful or those who suffer deserve it.\n"));
        this.list.add(new FactData("It is a proven fact that when you are faced with a bigger challenge, your drive to do it and do it better become stronger too.\n"));
        this.list.add(new FactData("Research shows that people believe fake news because it's easier than critically evaluating and analysing everything else they've heard.\n"));
        this.list.add(new FactData("A person who is being hurt may blame themselves. Choosing to feel guilty helps them restore the sense of being in control of their life.\n"));
        this.list.add(new FactData("Apologizing doesn't always mean you're wrong and the other person is right. It means you value your relationship more than your ego.\n"));
        this.list.add(new FactData("We don't predict our reaction to future events very well.\n"));
        this.list.add(new FactData("There are more than 3,000 species of snakes in the world and there is at least one type of snake on every continent except Antarctica."));
        this.list.add(new FactData("Elephants are scared of bees. Elephants only sleep 2 to 3 hours each day. An elephant can smell water from 12 miles away. One of the most interesting fun facts about elephants is that they remain pregnant for 2 years."));
        this.list.add(new FactData("About 70% of the world’s spices come from India."));
        this.list.add(new FactData("\nAnimals do also have friends, but cows have been shown in studies to have ‘best friends’ – even showing signs of distress when they get separated from them. Also, Cows have four stomachs.\n"));
        this.list.add(new FactData("A giraffe rarely lay down, they even sleep and give birth standing up. Giraffes are the only animals born with horns. They are born with bony k***s on their forehead."));
        this.list.add(new FactData("\nDid you know that dolphins do not chew with their teeth? \n"));
        this.list.add(new FactData("They only use them to emit sound, because when feeding they prefer to swallow food in a single gulp."));
        this.list.add(new FactData("Dolphins are another species that are often focussed on for their smarts. A recent finding that exemplifies this is that dolphins have names for one another (which form when other dolphins mimic the sounds they make) – and recognise their own title when it is called by other dolphins."));
        this.list.add(new FactData("Did you know that the giraffe has 35 teeth? "));
        this.list.add(new FactData("The voluntary nature of friendships, and our mutual commitment to relationships are the hallmarks of any friendship’s very existence. Unless two people consider their relationship a friendship, it simply doesn’t exist.\n"));
        this.list.add(new FactData("Multilingual people may unconsciously shift their personalities when going from one language to another.\n"));
        this.list.add(new FactData("People who constantly use \"to be honest\" when responding to a question are more likely to be lying to you.\n"));
        this.list.add(new FactData("People who blush easily are more generous and trustworthy than those who don’t.\n"));
        this.list.add(new FactData("People will remember not what you said, but how you made them feel. A good reason not to over focus on what you did and didn’t say.\n"));
        this.list.add(new FactData("People who complain online are more likely to suffer from anxiety, depression, and stress.\n"));
        this.list.add(new FactData("When your group of friends laughs at a joke, if constantly someone of the opposite sex tries to look into your eyes, it means he/she is interested in you. Because at laughter perks, we look at the people we care about the most.\n"));
        this.list.add(new FactData("People forget to notice things when they are tense even if it is in front of them.\n"));
        this.list.add(new FactData("For deeppsy, when you try to learn the meaning of the word “humongous”, associate it with a lot of smaller words like “huge”, “large”, “big”, “Hulk”, etc. The more words you associate, the better you are able to learn.\n"));
        this.list.add(new FactData("The more stressed you are, the slower your wounds and illnesses heal.\n"));
        this.list.add(new FactData("If a person is biting the arms of their glasses, that indicates that they are definitely worried about something at a subconscious level.\n"));
        this.list.add(new FactData("When talking to somebody, looking anywhere other than his face is the most powerful “I'm lame and unconfident” message emitter you can use.\n"));
        this.list.add(new FactData("Getting and keeping someone’s attention and attraction is believed to have more to do with body language and tone and speed of your voice rather than things that you say.\n"));
        this.list.add(new FactData("Studies have also shown that people who dress well feel better about themselves and are generally happier.\n"));
        this.list.add(new FactData("You’re more likely to achieve your goals if you keep them to yourself.\n"));
        this.list.add(new FactData("Children are not blank slates on which adults imprint knowledge\n"));
        this.list.add(new FactData("Getting in music rhythms helps children grasp fractions.\n"));
        this.list.add(new FactData("An average baby will triple his birth weight in his first year.\n"));
        this.list.add(new FactData("According to a study, children are less likely to trust ugly people.\n"));
        this.list.add(new FactData("Children inherit their intelligence from their mothers, according to Scientists.\n"));
        this.list.add(new FactData("We cannot snore and dream at the same time.\n"));
        this.list.add(new FactData("People are more productive in a blue room.\n"));
        this.list.add(new FactData("People who blush easily are more generous and trustworthy than those who don’t.\n"));
        this.list.add(new FactData("We are subconsciously more attracted to people who have the same music taste as we do.\n"));
        this.list.add(new FactData("Your body makes you attractive. Your smile makes you pretty. But your personality makes you beautiful.\n"));
        this.list.add(new FactData("Interrogative self-talk --e.g. Will I go for a run today? It is more motivating than declaring something to be true, a study found.\n"));
        this.list.add(new FactData("People who are lying to you tend to look up and they're left.\n"));
        this.list.add(new FactData("Happy people smile 40-50 times a day, the average us only does so 20 times.\n"));
        this.list.add(new FactData("Kissing releases Oxytocin in the brain, a hormone that strengthens the emotional bond between two people to increase happiness in their life.\n"));
        this.list.add(new FactData("Laughter denotes social status. The higher up in the hierarchy you are in the group, the less you will laugh.\n"));
        this.list.add(new FactData("Happiness is contagious, and when you're positive, people are naturally drawn to you.\n"));
        this.list.add(new FactData("Money does not buy happiness. After having your basic material needs met, additional money does not have any impact on your levels of happiness.\n"));
        this.list.add(new FactData("Positive emotions can make you more resilient and happier.\n"));
        this.list.add(new FactData("A widely looped \"l\" suggests you're relaxed and spontaneous, while a narrow or retraced \"l\" means you might be restricting yourself.\n"));
        this.list.add(new FactData("You never know how strong you are until being strong is the only choice you have.\n"));
        this.list.add(new FactData("It's impossible to remain angry at someone you truly love. Anger lasting for more than 3 days indicates that you are not in love."));
        this.list.add(new FactData("Making yourself angry can help you hide the reality that you find a situation frightening or that you feel vulnerable."));
        this.list.add(new FactData("People tend to commit immoral acts or do not fulfil someone’s request for help if no effort is needed and they do not have to refuse a person directly. However, more people behave “as expected” if they have to make a moral decision in front of others.\n"));
        this.list.add(new FactData("Always be happy in front of people who don't like you. It kills them.\n"));
        this.list.add(new FactData("The richer you get, the more expensive happiness become.\n"));
        this.list.add(new FactData(" In an online dating world, women afraid of meet a serial killer. Men are afraid of meeting someone fat.\n"));
        this.list.add(new FactData(" As per study, 43% said fresh breath matters before date, 17% said stylish clothes, 15% said sexy fragrance, 14% said good skin and 10% said good hair.\n"));
        this.list.add(new FactData("Happy people attract more dates.\n"));
        this.list.add(new FactData("Nearly 40% of men do not feel confident meeting a woman for the first time. \n"));
        this.list.add(new FactData("colour therapy has been around for 5,000 years, since ancient Egyptians wore coloured sacred stones and Hindu healers linked the colour spectrum to the body’s seven vital chakras.\n"));
        this.list.add(new FactData("Bulls don’t seem to care about what colour is being waved in front of them. It turns out it’s the motion which triggers the bull to charge, not the colour.\n"));
        this.list.add(new FactData("Study shows remembering bits of information about a person and working them to conversations not only is highly flattering but also shows a lot of interest.\n"));
        this.list.add(new FactData("Couples usually wait until six to eight dates before they are willing to enter into an exclusive relationship.\n"));
        this.list.add(new FactData(" The most time for breakups is around three to five months.\n"));
        this.list.add(new FactData(" The same study found that men who reported incomes higher than $250,000 received 156% more email than those with $50,000.\n"));
        this.list.add(new FactData("On average, it takes between 12 to 14 dates before couples will trade house keys.\n"));
        this.list.add(new FactData("If a man can’t decide what to wear on a date, he might want to wear blue. Studies show that women are attracted to men in blue\n"));
        this.list.add(new FactData("The best time to call after meeting someone is within two to four days, and no more than four to five days.\n"));
        this.list.add(new FactData("Study suggested that the variability in this trait might be linked to differences in cortical arousal. Extroverts tend to need more external stimulation while introverts tend to become stimulated very easily.\n"));
        this.list.add(new FactData("Extroverts place their feelings out in the open and have little fear of judgment. They thus tend to be happier people and their many friends are good resources too.\n"));
        this.list.add(new FactData("They are highly likely to compromise their own happiness or comfort to make someone that they care about happy.\n"));
        this.list.add(new FactData("People who are high in extroversion need social stimulation to feel energized. They gain inspiration and excitement from talking and discussing ideas with other people.\n"));
        this.list.add(new FactData("Extroverts can be great listeners even though they are thought to be overly talkative. They also tend to be very understanding and likely to know how comforting this to say.\n"));
        this.list.add(new FactData("The extrovert boys are very friendly. They are also very talkative and like to make new friends and like the social gathering.\n"));
        this.list.add(new FactData("If you smile when no one is around, you really mean it.\n"));
        this.list.add(new FactData("Being surrounded by the colour yellow helps you stay focused. Yellow decreases the production of Melatonin, a hormone which makes you sleepy.\n"));
        this.list.add(new FactData("Brown coloured eyes are really blue, under a layer of melanin.\n"));
        this.list.add(new FactData("Blue is the world’s favourite colour. Studies done around the world reveal that a whopping 40% of people consider blue to be their favourite colour. That's why you are attracted to Facebook More because it has a combination of blue and white.\n"));
        this.list.add(new FactData("Bright colours Can Improve Your Social Life. We live in a very visual culture and it is estimated that the colour of the clothes we wear can influence first impressions by up to 90%. colours send a message, and bright, festive colours tend to send a more gregarious message than dark or drab tones.\n"));
        this.list.add(new FactData("Shades of blue are supposed to be calming, while a colour like bright orange encourages happiness and creativity.\n"));
        this.list.add(new FactData("Colours like Red, Orange and Yellow makes you hungry.\n"));
        this.list.add(new FactData("Over 8% of adolescents in the United States suffer from depression at a given time.\n"));
        this.list.add(new FactData("Depressed brains look different., brain can show some of the structures and brain circuits that work differently when a person is depressed.\n"));
        this.list.add(new FactData("Exercise help ease depression; it also even helps prevent the onset of depression later in life. \n"));
        this.list.add(new FactData("Cause of depression the rate of suicide in men is 4 times that of women.\n"));
        this.list.add(new FactData("Placebo can be used as an effective treatment for depression, and it actually makes antidepressants work even better.\n"));
        this.list.add(new FactData("Controlling Facial Muscles Can Help Control your Anger. Studies have shown that if you don’t frown when you’re angry, you won’t feel the emotion in much intensity.\n"));
        this.list.add(new FactData("Men who have low levels of testosterone served as a threat to masculinity and led to engagement in more “gender stereotypical behaviours,” like getting into physical fights and anger."));
        this.list.add(new FactData("The happier we are, the less sleep we require.\n"));
        this.list.add(new FactData("Didaskaleinophobia is the fear of going to school.\n"));
        this.list.add(new FactData("Excessive anger can cause problems. Increased blood pressure and other physical changes associated with anger make it difficult to think straight and harm your physical and mental health."));
        this.list.add(new FactData("One thing that has been shown to consistently combat anger is humour. Not only do most people enjoy humour, but it breaks the attention and stress caused by feeling angry and refocuses it on something less physiologically taxing."));
        this.list.add(new FactData("Angry people produce more unique ideas faster than people in any other type of emotional state, according to a study."));
        this.list.add(new FactData("Angry people most always feel that their anger is justified. However, other people don't always agree. The social judgment of anger creates real consequences for the angry person."));
        this.list.add(new FactData("People don't listen to the smartest person in the room, they listen to whoever acts as if they know what's right, according to a study.\n"));
        this.list.add(new FactData("People are usually interested in bad people or things, eg; Sweet girl behind jerk, or at least get excited or think about it.\n"));
        this.list.add(new FactData("Men and women who listen to similar music tend to be better communicators and have longer lasting relationships.\n"));
        this.list.add(new FactData("We prefer shorter lines of text but read longer ones better.\n"));
        this.list.add(new FactData("Depressing can cause you to dream up to 3 to 4 times more and have more intense nightmares than you normally would. \n"));
        this.list.add(new FactData("Spending too much time on the internet or social media can lead to depression and make you mentally unstable. \n"));
        this.list.add(new FactData("Comedian and funniest people are often the saddest.\n"));
        this.list.add(new FactData(" One in three teenagers have experienced violence in a dating relationship.\n"));
        this.list.add(new FactData("According to a study by Boston Children's Hospital, children with musical training have enhanced executive functioning.\n"));
        this.list.add(new FactData("Your child understands what you are saying before they begin to speak.\n"));
        this.list.add(new FactData("Children behave better when parents are involved in their education at home and at school.\n"));
        this.list.add(new FactData("Phonemic awareness and alphabet recognition increase children’s chances of reading achievement.\n"));
        this.list.add(new FactData("Supplementation with vitamins can reduce the risk of child mortality from all causes by 23 percent. (2009 UNICEF report: Tracking Progress on Child and Maternal Nutrition)\n"));
        this.list.add(new FactData("If you hold hands with someone you love, this can help to alleviate physical pain as well as any feelings of stress and fear.\n"));
        this.list.add(new FactData("People generally prefer an attractive face over an attractive body when it comes to long-term relationships.  However, when people are looking for a fling, the body will win over the face on the basis of physical attraction.\n"));
        this.list.add(new FactData("Women who post a photo on Internet dating sites receive twice as many email messages as women who don’t.\n"));
        this.list.add(new FactData("Iceland is the most depressed country in the world.\n"));
        this.list.add(new FactData("Depression can cause you age faster.\n"));
        this.list.add(new FactData("Extroverts like when someone asks them for advice. they are very happy to be the adviser.\n"));
        this.list.add(new FactData("Aerophobia, or the fear of flying, affects an estimated 8 million U.S. adults despite the fact that airplane accidents are very uncommon. Around 1 out of every 3 people has some level of fear of flying. Some of the common symptoms associated with this phobia include trembling, rapid heartbeat, and feeling disoriented.\n"));
        this.list.add(new FactData("Acrophobia fear can lead to anxiety attacks and avoidance of high places. People who suffer from this phobia may go to great lengths to avoid high places such as bridges, towers, or tall buildings.\n"));
        this.list.add(new FactData("Phobophobia - is the fear of having a phobia.\n"));
        this.list.add(new FactData("In a lifetime, you make many friends, but psychologically only 1 out of 12 friendships lasts forever according to mind capabilities reviewed in survey.\n"));
        this.list.add(new FactData("Treating everyone like they are a good friend may make your path through life a little easier. Being kind, providing favours, and helping others can make you feel better about yourself and life.\n"));
        this.list.add(new FactData("When faced with a major illness, individuals with a good social network are in a better position to survive.\n"));
        this.list.add(new FactData("Close friends share about 1% of their DNA with you.\n"));
        this.list.add(new FactData("Phobias may be memories passed down through generations of DNA, according to new research.\n"));
        this.list.add(new FactData("Extroversion clearly has a strong genetic component. Twin studies suggest that genetics contribute somewhere between 40 and 60 percent of the variance between extroversion and introversion.\n"));
        this.list.add(new FactData("Extroverted individuals are often more “touchy-feely” than their introverted counterparts. While an extrovert might go for a hug when seeing a friend, an introvert is less likely to initiate such contact.\n"));
        this.list.add(new FactData("The extrovert is characteristically the active person who is most content when surrounded by people; carried to the neurotic extreme such behaviour appears to constitute an irrational flight into society, where the extrovert's feelings are acted out.\n"));
        this.list.add(new FactData("Extroverts don't understand their introverted friends at all. Most of the time they try to make introverts like them.\n"));
        this.list.add(new FactData("Extroverts love travelling and love to explore new places and experience.\n"));
        this.list.add(new FactData("\nAnger cannot make pain disappear - it only distracts you from it.\n"));
        this.list.add(new FactData("Blind people's dream typically include information from other senses such as taste , sound and touch.\n"));
        this.list.add(new FactData("We are paralyzed during our dreams. The phenomenon is known as REM atonia.\n"));
        this.list.add(new FactData("Many dreams are common and universal. Common dreams  experience includes school events, feeling frozen unable to move, arriving late, being chased, attached   and falling.\n"));
        this.list.add(new FactData("If you do sex with a known person in a dream, means you want to be like them.\n"));
        this.list.add(new FactData("The average person has about 1460 and 2190 dreams a year. \n"));
        this.list.add(new FactData("Shared interests and proximity—real or virtual—are the fastest paths to finding friends, and if that intersection of two lives begins online, it can yet develop into its own type of relationship over time.\n"));
        this.list.add(new FactData("Animals can form lifelong friendships with individuals that are not from their own species. Many studies have shown that chimpanzees, baboons, cows, horses, elephants and dolphins make friends, not necessarily from their own species. In fact, whales literally have BFFs!\n"));
        this.list.add(new FactData("Being with happy people makes you happier.\n"));
        this.list.add(new FactData("Blind people can dream.\n"));
        this.list.add(new FactData("The origin of human laughter is as a primate warning signal and is closely related to crying.\n"));
        this.list.add(new FactData("When reading body language, 14–16 areas of a woman’s brain are active. Men show just 4–6 active areas.\n"));
        this.list.add(new FactData("Whether it's through helping charity or just a small act of kindness, altruism makes us feel good. One study even found that happiness gleaned from volunteering can increase your longevity and happiness.\n"));
        this.list.add(new FactData("If you have a quick wit or pride yourself on being a fast reader, you may also have a more positive mood. A study published in Psychological Science discovered that happiness was more commonly associated with faster cognitive thoughts.\n"));
        this.list.add(new FactData("Dancing has been proven to build confidence and release stress.\n"));
        this.list.add(new FactData("Gratitude can boost dopamine and serotonin, just like antidepressants and make life happier.\n"));
        this.list.add(new FactData("Women are more prone to extreme mood swings, Women tend to think more about those who ignore them, than those who constantly talk to them.\n"));
        this.list.add(new FactData("Women’s eyes speak a lot, and it's the doorway to her heart.\n"));
        this.list.add(new FactData("Within 5 minutes of waking up, 50% of your dream is forgotten.\n"));
        this.list.add(new FactData("We can only dream about things we already know.\n"));
        this.list.add(new FactData("The faces of people we see in the dreams are faces we have seen before in real life.\n"));
        this.list.add(new FactData("Approximately 80% of all dreams are in colour, there are small percentages of people who claim to only dream in black and white.\n"));
        this.list.add(new FactData("Crying makes you feel better, reduces stress and may help to keep your body healthy.\n"));
        this.list.add(new FactData("Singing in the shower daily can help boost your immunity, lower blood pressure, reduce stress and improve your mood.\n"));
        this.list.add(new FactData("For developing a new habit, follow it for 21 days, it will eventually become a routine.\n"));
        this.list.add(new FactData("\"Trans abled\" people cut off their own limbs to become disabled. That makes them feel more comfortable in their own body.\n"));
        this.list.add(new FactData("A study published in Personality and Social Psychology Bulletin found that, while men were attracted to nice-seeming women upon meeting them, women did not feel the same way about nice men.\n"));
        this.list.add(new FactData("\"Wrap rage\" is the anger and frustration felt when you are unable to open packages.\n"));
        this.list.add(new FactData("$160 billion a year is the value of global industry that includes cosmetics, skin and hair care, perfumes, cosmetic surgery, hormone injection, health clubs and weight loss programs. \n"));
        this.list.add(new FactData("Researches show that a potential date is made more attractive by adrenaline. \n"));
        this.list.add(new FactData("People who are drunk find others more attractive because person is less likely to notice the asymmetry of a face. \n"));
        this.list.add(new FactData("Women judge a man to be more attractive when they, see other women looking or smiling at him. \n"));
        this.list.add(new FactData("People who make the first move will be more attractive and get attracted. \n"));
        this.list.add(new FactData("Studies show that, neonatal nurses tend to devote more time and attention to more attractive, healthy infants and less attention to less attractive babies.\n"));
        this.list.add(new FactData("As per studies mothers tend to give more attention to the most attractive children who exhibited more socialize behaviour then their less attractive siblings. \n"));
        this.list.add(new FactData("A study conducted in the United Kingdom found that whenever a woman finds a man attractive, when he speaks with a higher pitched voice.\n"));
        this.list.add(new FactData("When a man spots a woman, He finds attractive, he holds his stare for an average of 82 seconds. \n"));
        this.list.add(new FactData("Remember: Not every friendship is going to be a “friends forever” type of relationship; sometimes, it is about “friends of convenience” and those we need most in a situation. And if things grow less convenient, and that individual isn’t available in the way that he or she once used to be, that’s quite alright.\n"));
        this.list.add(new FactData(" Four out of 10 workplace dating relationships results in marriage.\n"));
        this.list.add(new FactData("Dating specialists suggest that if a woman doesn't return a call after two messages, she is not interested.\n"));
        this.list.add(new FactData("Twenty-nine percent of Americans have had sex on the first date.\n"));
        this.list.add(new FactData("Italian food is one of the most popular restaurants for the first date.\n"));
        this.list.add(new FactData(" Twenty to 40 million Americans have used online dating services. Nearly 50% of online daters are aged 18-34 and 24% are 35-44.\n"));
        this.list.add(new FactData("Approximately 48% of online daters reported that their breakups occurred via email. \n"));
        this.list.add(new FactData("The brain treats rejection like physical pain, according to scientists. This affects our mental health.\n"));
        this.list.add(new FactData("Tip: If you chew gum when you study a subject and then chew the same flavour when you the take the test it can help you remember.\n"));
        this.list.add(new FactData("Get a small pan and fill it with water. Add some vanilla extract and cinnamon and put on the stove. Your house will smell like a bakery.\n"));
        this.list.add(new FactData("Try to achieve something small like getting up early, going for a run or even organizing your wardrobe. Then the next day do something else and in a few months’ time you will be so confident and energized that taking on the big tasks would feel no big deal.\n"));
        this.list.add(new FactData("Thinking about how your muscles can make you stronger.\n"));
        this.list.add(new FactData("The tone of a woman’s voice naturally increases when she’s flirting.\n"));
        this.list.add(new FactData("The quickest way to a person’s heart is through their…eyes.\n"));
        this.list.add(new FactData("The more you have self-confidence, the more people you attract.\n"));
        this.list.add(new FactData("During your college life, on what basis did you rate your teachers?  Studies show that students tend to rate their teacher’s performance more on the basis of physical attractiveness than on the knowledge and their ability to explain.\n"));
        this.list.add(new FactData("Women are attracted to different things depending on where they are in their menstrual cycle. Studies show that when a woman is in her most fertile stage, she will prefer men who have more masculine features; deeper voices, more symmetrical faces (an indicator of strong genetics), competitiveness, and victory over other males.\n"));
        this.list.add(new FactData("Research has found that while ovulating, women prefer masculine looking men. But at other times of the month they seek men with softer features.\n"));
        this.list.add(new FactData("According to researchers, women who have shown ideal and perfect body images usually lower their satisfaction with their own attractiveness.\n"));
        this.list.add(new FactData("Do you know that facial symmetry is considered a sign of beauty and attraction around the world?\n"));
        this.list.add(new FactData(str27));
        this.list.add(new FactData("Humans share 50% of their DNA with bananas. It may be shocking but Psychologically it's true."));
        this.list.add(new FactData("There are more living organisms in a 1 teaspoonful of soil than there are people alive on Earth.\n"));
        this.list.add(new FactData(str15));
        this.list.add(new FactData(str13));
        this.list.add(new FactData("Men socialize by insulting each other but they don't really mean it. Women socialize by complementing each other,  and they don't really mean it either.\n"));
        this.list.add(new FactData("Women communicate more with non-verbal gestures than verbally to loved ones.\n"));
        this.list.add(new FactData("When women are upset over something, they like to share their problems with others and if you patiently hear their problem then they feel better.\n"));
        this.list.add(new FactData("Women who have mostly male friends stay in a good mood more often.\n"));
        this.list.add(new FactData("Women are socially conscious and dress as per the occasion. It will be nice if you match your clothing accordingly.\n"));
        this.list.add(new FactData("When a woman no longer gets frustrated and upset with you, you can almost guarantee that she doesn’t care anymore.\n"));
        this.list.add(new FactData("Women are more attracted to men who pay attention, someone who remembers details about them without having to be reminded.\n"));
        this.list.add(new FactData("Women are likely to remember what men with deep voices say.\n"));
        this.list.add(new FactData("30% of pregnant women crave non-food items, an eating disorder called pica.\n"));
        this.list.add(new FactData("Women with higher IQ's have a harder time finding a mate. Intelligent women would rather remain single than be with the wrong person.\n"));
        this.list.add(new FactData("Women communicate more with non-verbal gestures than verbally.\n"));
        this.list.add(new FactData("Girls learn to talk earlier, use sentences earlier and tend to read quicker than boys.\n"));
        this.list.add(new FactData("On average, dates kiss on the second date. \n"));
        this.list.add(new FactData("Females are better at multitasking than males according to studies. For deeppsy, Household things, Cooking, Cleaning etc.\n"));
        this.list.add(new FactData("Females deal with stress by joining or socializing with others, whereas males they love to fly away or get into fights with others.\n"));
        loadData();
        ((TextView) findViewById(R.id.viewpagertext1)).setText(((FactData) this.list.get(this.position)).getTitle());
        ImageView imageView1 = (ImageView) findViewById(R.id.share_horizontal);
        ImageView imageView2 = (ImageView) findViewById(R.id.copy_horizontal);
        final ImageView imageView3 = (ImageView) findViewById(R.id.save);
        int i = 0;
        while (true) {
            if (i >= this.mFavData.size()) {
                break;
            } else if (((FactData) this.list.get(this.position)).getTitle().equals(((FavData) this.mFavData.get(i)).getTitle())) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z) {
            imageView3.setBackgroundResource(R.drawable.ic_bookmark_blue);
        } else {
            imageView3.setBackgroundResource(R.drawable.ic_bookmark_white_24dp);
        }
        imageView1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                Toast.makeText(FactOfTheDayActivity.this.getApplicationContext(), "Sharing...", Toast.LENGTH_LONG).show();
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("text/plain");
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(((FactData) FactOfTheDayActivity.this.list.get(FactOfTheDayActivity.this.position)).getTitle());
                stringBuilder.append("\n\nFor More Download the PsychologyFacts App now:");
                stringBuilder.append("\n");
                stringBuilder.append("https://play.google.com/store/apps/details?id=com.example.psychologyfacts");
                intent.putExtra("android.intent.extra.TEXT", stringBuilder.toString());
                intent.putExtra("android.intent.extra.SUBJECT", "hello");
                FactOfTheDayActivity.this.startActivity(intent);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                ((ClipboardManager) FactOfTheDayActivity.this.getSystemService(Context.CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("CopyText", ((FactData) FactOfTheDayActivity.this.list.get(FactOfTheDayActivity.this.position)).getTitle()));
                Toast.makeText(FactOfTheDayActivity.this.getApplicationContext(), "Copied to clipboard.", Toast.LENGTH_LONG).show();
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                byte b = 0;
                while (true) {
                    int i = FactOfTheDayActivity.this.mFavData.size();
                    byte b1 = 1;
                    if (b < i) {
                        if (((FactData) FactOfTheDayActivity.this.list.get(FactOfTheDayActivity.this.position)).getTitle().equals(((FavData) FactOfTheDayActivity.this.mFavData.get(b)).getTitle())) {
                            Toast.makeText(FactOfTheDayActivity.this.getApplicationContext(), "Removed from bookmark", Toast.LENGTH_SHORT).show();
                            FactOfTheDayActivity.this.mFavData.remove(b);
                            FactOfTheDayActivity.this.saveData();
                            imageView3.setBackgroundResource(R.drawable.ic_bookmark_white_24dp);
                            b = b1;
                            break;
                        }
                        b++;
                        continue;
                    }
                    b = 0;
                    break;
                }
                if (b == 0) {
                    Toast.makeText(FactOfTheDayActivity.this.getApplicationContext(), "Saved to bookmark", Toast.LENGTH_LONG).show();
                    FactOfTheDayActivity.this.mFavData.add(new FavData(((FactData) FactOfTheDayActivity.this.list.get(FactOfTheDayActivity.this.position)).getTitle(), ((FactData) FactOfTheDayActivity.this.list.get(FactOfTheDayActivity.this.position)).getTitle(), "Fact of the day"));
                    imageView3.setBackgroundResource(R.drawable.ic_bookmark_white_24dp);
                    FactOfTheDayActivity.this.saveData();
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            finish();
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);

    }
}


