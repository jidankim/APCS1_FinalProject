public class CampaignTest {

  public static void main(String [] args){
    Candidate a = new Candidate("Alexander","Hamilton");
    Candidate b = new Candidate("Benjamin","Franklin");
    a.attackAd(400000);
    b.holdRally(700000);
    b.hireStaff();
    a.straightTalk(500000);
    b.attackAd(1000000);
    a.holdRally(300000);
    System.out.println("Alexander Hamilton's funding: " + a.getFunds());
    System.out.println("Percentage of people who will vote for Alexander Hamilton: " + a.getSupport() + " %");
    System.out.println("Sally's # jumps: " + b.getFunds());
    System.out.println("Percentage of people who will vote for Benjamin Franklin: " + b.getSupport() + " %");
    System.out.println("Benjamin Franklin polls higher than Alexander Hamilton?  " + (b.compareTo(a) > 0));
  }


}
