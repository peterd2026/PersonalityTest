import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Personality {

    private Scanner input = new Scanner(System.in);

    FileTools fileTools = new FileTools();

    public void showQuestion(String name) {
        // total answer
        int[] score = new int[3];
        //call questionReader method
        List QnList = fileTools.QuestionReader(name);
        //note down result (letter received) from each 15 question section
        List<String> scoreList = new ArrayList<>();

        //print questions
        for (int i = 0; i < QnList.size(); i++) {
            //print each index from QnList where questions are stored
            System.out.println(QnList.get(i));
            //conditional, used for every 3 lines so the user can input their answer
            if ((i + 1) % 3 == 0) {
                boolean isR = true;
                while (isR) {
                    System.out.println("Please input your answer A/B");
                    String answer = input.nextLine();
                    if (answer.equalsIgnoreCase("A") || answer.equalsIgnoreCase("B") || answer.equals("-")) {
                        score = totalResult(score, answer);
                        isR = false;
                    } else {
                        System.out.println("Input error, please enter again");
                        isR = true;
                    }
                }

            }

            if (((i + 1) / (3 * 15) == 1) && (i + 1) % (3 * 15) == 0) {
                if (score[0] > score[1]) {
                    scoreList.add("E");
                } else {
                    scoreList.add("I");
                }
                //reset
                score = new int[3];
            } else if (((i + 1) / (3 * 30) == 1) && (i + 1) % (3 * 30) == 0) {
                if (score[0] > score[1]) {
                    scoreList.add("S");
                } else {
                    scoreList.add("N");
                }
                score = new int[3];
            } else if (((i + 1) / (3 * 45) == 1) && (i + 1) % (3 * 45) == 0) {
                if (score[0] > score[1]) {
                    scoreList.add("T");
                } else {
                    scoreList.add("F");
                }
                score = new int[3];
            } else if (((i + 1) / (3 * 60) == 1) && (i + 1) % (3 * 60) == 0) {
                if (score[0] > score[1]) {
                    scoreList.add("J");
                } else {
                    scoreList.add("P");
                }
                score = new int[3];
            }

        }
        showResult(scoreList);
    }

    public void showResult(List<String> scoreList) {
        //initialize string buffer to easily add new lines
        StringBuffer sb = new StringBuffer();
        System.out.println("Please enter your name: ");
        String name = input.next();

        //append is to append a value to the current sequence
        sb.append(name + "'s Personality Test Results\n");
        sb.append("**********************************************\n");

        String str = "";
        //Turn personality type stored in array list into a string
        for (int i = 0; i < scoreList.size(); i++) {
            str += scoreList.get(i);
        }
        sb.append("Your personality type is: " + str + "\n");

        //According to the type of personality print description
        if (str.equals("INTJ")) {
            sb.append("People with the INTJ personality type (Architects) are intellectually curious individuals with a deep-seated thirst for knowledge. INTJs tend to value creative ingenuity, straightforward rationality, and self-improvement. They consistently work toward enhancing intellectual abilities and are often driven by an intense desire to master any and every topic that piques their interest.\n");
        } else if (str.equals("INTP")) {
            sb.append("People with the INTP personality type (Logicians) pride themselves on their unique perspective and vigorous intellect. They can’t help but puzzle over the mysteries of the universe – which may explain why some of the most influential philosophers and scientists of all time have been INTPs. People with this personality type tend to prefer solitude, as they can easily become immersed in their thoughts when they are left to their own devices. They are also incredibly creative and inventive, and they are not afraid to express their novel ways of thinking or to stand out from the crowd.\n");
        } else if (str.equals("ENTJ")) {
            sb.append("People with the ENTJ personality type (Commanders) are natural-born leaders. Embodying the gifts of charisma and confidence, ENTJs project authority in a way that draws crowds together behind a common goal. However, these personalities are also characterized by an often ruthless level of rationality, using their drive, determination, and sharp mind to achieve whatever objectives they’ve set for themselves. Their intensity might sometimes rub people the wrong way, but ultimately, ENTJs take pride in both their work ethic and their impressive level of self-discipline.\n");
        } else if (str.equals("ENTP")) {
            sb.append("Quick-witted and audacious, people with the ENTP personality type (Debaters) aren’t afraid to disagree with the status quo. In fact, they’re not afraid to disagree with pretty much anything or anyone. Few things light up these personalities more than a bit of verbal sparring – and if the conversation veers into controversial terrain, so much the better.\n");
        } else if (str.equals("INFJ")) {
            sb.append("Idealistic and principled, people with the INFJ personality type (Advocates) aren’t content to coast through life – they want to stand up and make a difference. For these compassionate personalities, success doesn’t come from money or status but from seeking fulfillment, helping others, and being a force for good in the world.\n");
        } else if (str.equals("INFP")) {
            sb.append("Although they may seem quiet or unassuming, people with the INFP personality type (Mediators) have vibrant, passionate inner lives. Creative and imaginative, they happily lose themselves in daydreams, inventing all sorts of stories and conversations in their mind. INFPs are known for their sensitivity – these personalities can have profound emotional responses to music, art, nature, and the people around them. They are known to be extremely sentimental and nostalgic, often holding onto special keepsakes and memorabilia that brighten their days and fill their heart with joy.\n");
        } else if (str.equals("ENJF")) {
            sb.append("People with the ENFJ personality type (Protagonists) feel called to serve a greater purpose in life. Thoughtful and idealistic, ENFJs strive to have a positive impact on other people and the world around them. These personalities rarely shy away from an opportunity to do the right thing, even when doing so is far from easy.\n");
        } else if (str.equals("ENFP")) {
            sb.append("People with the ENFP personality type (Campaigners) are true free spirits – outgoing, openhearted, and open-minded. With their lively, upbeat approach to life, ENFPs stand out in any crowd. But even though they can be the life of the party, they don’t just care about having a good time. These personalities have profound depths that are fueled by their intense desire for meaningful, emotional connections with others.\n");
        } else if (str.equals("ISTJ")) {
            sb.append("People with the ISTJ personality type (Logisticians) mean what they say and say what they mean, and when they commit to doing something, they make sure to follow through. With their responsible and dependable nature, it might not be so surprising that ISTJ personalities also tend to have a deep respect for structure and tradition. They are often drawn to organizations, workplaces, and educational settings that offer clear hierarchies and expectations.\n");
        } else if (str.equals("ISFJ")) {
            sb.append("In their unassuming, understated way, people with the ISFJ personality type (Defenders) help make the world go round. Hardworking and devoted, these personalities feel a deep sense of responsibility to those around them. ISFJs can be counted on to meet deadlines, remember birthdays and special occasions, uphold traditions, and shower their loved ones with gestures of care and support. But they rarely demand recognition for all that they do, preferring instead to operate behind the scenes.\n");
        } else if (str.equals("ESTJ")) {
            sb.append("People with the ESTJ personality type (Executives) are representatives of tradition and order, utilizing their understanding of what is right, wrong, and socially acceptable to bring families and communities together. Embracing the values of honesty and dedication, ESTJs are valued for their mentorship mindset and their ability to create and follow through on plans in a diligent and efficient manner. They will happily lead the way on difficult paths, and they won’t give up when things become stressful.\n");
        } else if (str.equals("ESFJ")) {
            sb.append("For people with the ESFJ personality type (Consuls), life is sweetest when it’s shared with others. These social individuals form the bedrock of many communities, opening their homes – and their hearts – to friends, loved ones, and neighbors.\n");
        } else if (str.equals("ISTP")) {
            sb.append("People with the ISTP personality type (Virtuosos) love to explore with their hands and their eyes, touching and examining the world around them with an impressive diligence, a casual curiosity, and a healthy dose of skepticism. They are natural makers, moving from project to project, building the useful and the superfluous for the fun of it and learning from their environment as they go. They find no greater joy than in getting their hands dirty pulling things apart and putting them back together, leaving them just a little bit better than they were before.\n");
        } else if (str.equals("ISFP")) {
            sb.append("People with the ISFP personality type (Adventurers) are true artists – although not necessarily in the conventional sense. For these types, life itself is a canvas for self-expression. From what they wear to how they spend their free time, they act in ways that vividly reflect who they are as unique individuals. With their exploratory spirit and their ability to find joy in everyday life, ISFPs can be among the most interesting people you’ll ever meet.\n");
        } else if (str.equals("ESTP")) {
            sb.append("People with the ESTP personality type (Entrepreneurs) are vibrant individuals brimming with an enthusiastic and spontaneous energy. They tend to be on the competitive side, often assuming that a competitive mindset is a necessity in order to achieve success in life. With their driven, action-oriented attitudes, they rarely waste time thinking about the past. In fact, they excel at keeping their attention rooted in their present – so much so that they rarely find themselves fixated on the time throughout the day.\n");
        } else if (str.equals("ESFP")) {
            sb.append("If anyone is to be found spontaneously breaking into song and dance, it is people with the ESFP personality type (Entertainers). They get caught up in the excitement of the moment and want everyone else to feel that way too. No other type is as generous with their time and energy when it comes to encouraging others, and no other type does it with such irresistible style.");
        }
        fileTools.writeResult(sb.toString(), name);
    }

    public int[] totalResult(int[] score, String answer) {
        if (answer.equalsIgnoreCase("A")) {
            score[0]++;
        } else if (answer.equalsIgnoreCase("B")) {
            score[1]++;
        } else {
            score[2]++;
        }

        return score;
    }
}
