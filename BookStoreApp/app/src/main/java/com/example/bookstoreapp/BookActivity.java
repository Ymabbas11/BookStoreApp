 package com.example.bookstoreapp;

 import android.content.Intent;
 import android.content.pm.ActivityInfo;
 import android.os.Build;
 import android.os.Bundle;
 import android.view.View;
 import android.widget.Button;
 import android.widget.ImageView;
 import android.widget.RatingBar;
 import android.widget.TextView;

 import androidx.appcompat.app.AppCompatActivity;
 import androidx.core.app.ActivityOptionsCompat;
 import androidx.core.util.Pair;
 import androidx.recyclerview.widget.LinearLayoutManager;
 import androidx.recyclerview.widget.RecyclerView;

 import com.example.bookstoreapp.databinding.ActivityBookBinding;
 import com.google.firebase.auth.FirebaseAuth;

 import java.util.ArrayList;
 import java.util.List;

 public class BookActivity extends AppCompatActivity implements BookCallback {

     private ActivityBookBinding binding;

     private FirebaseAuth firebaseAuth;

     private RecyclerView rvBooks;
     private BookAdapter bookAdapter;
     private List<Book> mdata ;
     private Button btnAddBook,btnRemove;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         binding = ActivityBookBinding.inflate(getLayoutInflater());
         setContentView(binding.getRoot());

         this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

         firebaseAuth = FirebaseAuth.getInstance();

         initViews();
         initmdataBooks();
         setupBookAdapter();

         binding.logoutBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 firebaseAuth.signOut();
                 startActivity(new Intent(BookActivity.this, MainActivity.class));
                 finish();
             }
         });

     }
     private void setupBookAdapter() {

         bookAdapter = new BookAdapter(this,mdata,this);
         rvBooks.setAdapter(bookAdapter);

     }

     private void initmdataBooks() {

         mdata = new ArrayList<>();
         mdata.add(new Book("Live Young Live Free","One of us is soon to tell in all its details the story of the life of Michael Bakounine, but its general features are already sufficiently familiar. Friends and enemies know that this man was great in thought, will, per- sistent energy ; they know also with what lofby contempt he looked down upon wealth, rank, glory, all the wretched ambitions which most human beings are base enough to entertain. A Russian gentleman related by marriage to the highest nobility of the empire, he was one of the first to enter that intrepid society of rebels who were able to release themselves from traditions, prejudices, race and class interests, and set their own comfort at nought. With them he fought the stern battle of life, aggra- vated by imprisonment, exile, all the dangers and all the sorrows that men of self-sacrifice have to undergo during their tormented existence.\n" +
                 "A simple stone and a name mark the spot in the cemetery of Berne where was laid the body of Bakounine. Even that is perhaps too much to honor the memory of a worker who held vanities of that sort in such slight esteem. His friends surely will raise to him no ostentatious tomb- stone or statue.","Noah Schumacher","110 Pages | 23 Reviews","215 Points",4,R.drawable.book01));
         mdata.add(new Book("Digital World","In Russia among the students, in Germany among the insurgents of Dresden, in Siberia among his brothers in exile, in America, in England, in France, in Switzerland, in Italy among all earnest men, his direct influence, has been considerable. The originality of his ideas, the imagery and vehemence of his eloquence, his untiring zeal in propagandism, helped too by the natural majesty^ of his person and by a powerful vitality, gave Bakounine access to all the socialistic revolutionary groups, and his efforts left deep traces every- where, even upon those who, after having welcomed him, thrust him out because of a difference of object or method. His correspondence was most extensive ; he passed entire nights in preparing long letters to his friends in the revolutionary world, and some of these letters, written to strengthen the timid, arouse the sluggish, and outline plans of propa- gandism or revolt, took on the proportions of veritable volumes. These letters more than anything else explain the prodigious work of Bakou- nine in the revolutionary movement of the century.","Donna Stroupe","345 Pages | 45 Reviews","123 Points",3,R.drawable.book2));
         mdata.add(new Book("The Season of the Windmill","The present mcMoir, ** God and the State,\" is really only a fragment of a letter or report. Composed in the same manner as most of Bakounine's other writings, it has the same literary fault, lack of proportion; more- over, it breaks oflf abruptly : we have searched in vain to discover the end of the manuscript. Bakounine never had the time necessary to finish all the tasks he undertook. One work was not completed when others were already under way. •* My life itself is a fragment,\" he said to those who criticised his writings. Nevertheless, the readers of * * God and the State '* certainly will not regret that Bakounine's memoir, incomplete though it be, has been published. The questions discussed in it are treated deci- sively and with a singular vigor of logic. Rightly addressing himself only to his honest opponents, Bakounine demonstrates to them the empti- ness of their belief in that divine authority on which all temporal author- ities are founded","Oliva Wilson","130 Pages | 348 Reviews","345 Points",3,R.drawable.book3));
         mdata.add(new Book("Beauty of Nature","In the -first place, soience is not : it is becoming. The learned man of today is but the know-nothing of tomorrow. Let him once Imagine that he has reached the end, and for that very reason he sinks beneath even the babe Just born. But, could he recognize truth in its essence, he can only corrupt himself by privilege and corrupt others by power. To establish his government he must try, like all chiefs of State, to arrest the life of the masses moving below him, keep them in ignorance in order to preserve quiet, and gradually debase them that he may rule them from a loftier throne.There is a class of people who, if they do not believe, must at least make a semblance of believing. This class comprises all the tormentors, all the oppressors, and all the exploiters of humanity : priests, monarchs, statesmen, soldiers, public and private financiers, ofilcials of all sorts, policemen, gendarmes, jailers and executioners, monopolists, capitalists, tax-leeches, contractors and propiletors, lawyers, economists, politicians of all shades, down to the smallest vender of sweetmeats, air will repeat in unison these words of Voltaire :","Hae-Won Jeon","500 Pages | 34 Reviews","112 Points",5,R.drawable.book4));
         mdata.add(new Book("Big Secret of Education","For the rest, since the *^ doctrinaires** made their appearance, .the true or pretended \"genius\" has been trying his hand at wielding the sceptre of the world, and we know what it has cost us. We have seen them at work, all these «ot;anto : the more hardened the more they have studied; the nartower in their views the more time they have spent in examining some isolated fact in all its aspects ; without any experience of life, because they have long known no other horizon than the walls of their cheese ; childish in their passions and vanities, because they have been unable to participate in serious struggles and have never learned the true proportion of things. Have we not recently witnessed the foundation of a whole school of ** thinkers,\" — wretched courtiers, too, and people of unclean lives, — who have constructed a complete cosmogony for their sole use","Shoo Phar Mhan","245 Pages | 234 Reviews","763 Points",4,R.drawable.book5));
         mdata.add(new Book("All the Little Things","Idealists of all schools, aristocrats and bourgeois, theologians and meta physicians, politicians and moralists, religionists, philosophers, or poets, not forgetting the liberal economists, — unbounded vrorshippers of the ideal, as we know, — are much oflfended when told that man, with his magnificent intelligence, his sublime ideas, and his boundless aspirations, is, like all else existing in the world, only a product of vile matter.First let it be remarked that not one of the illustrious men whom I have just named nor any other idealistic thinker of any consequence in oui day has given any attention to the logical side of this question properlv speaking. Not one has tried to settle philosophically the possibility of the divine salto mortale from the pure and eternal regions of spirit into the mire of the material world.","Clauda Wilson","760 Pages | 643 Reviews","450 Points",5,R.drawable.book6));

     }

     private void initViews() {

         btnAddBook = findViewById(R.id.btn_add);
         btnRemove = findViewById(R.id.btn_remove);
         rvBooks = findViewById(R.id.rv_book);
         rvBooks.setLayoutManager(new LinearLayoutManager(this));
         rvBooks.setHasFixedSize(true);

         rvBooks.setItemAnimator(new CustomItemAnimator());

         btnAddBook.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 addBook();
             }
         });

         btnRemove.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 removeBook();
             }
         });



     }

     private void removeBook() {

         mdata.remove(0);
         bookAdapter.notifyItemRemoved(0);

     }

     private void addBook() {

         Book book = new Book("The Gravity of Us","Who are right, the idealists or the materialists? The question once clearly stated, hesitation becomes impossible. Undoubtedly the idealists ore wrong and the materialists right. Yes, facts are before ideas ; yes, the ideal, as Proudhon said, is but a flower, whose root lies in the material conditions of existence. Yes, the whole history of humanity, intellectual and moral, political and social, is but a reflection of its economic history.\n" +
                 "All branches of modem science, of true and disinterested science, concur in proclaiming this grand troth, fundamental and decisive. Have they feared to approach this irre- concilable contradiction and despaired of solving it after the failures of the greatest geniuses of history, or have they looked upon it as already sufficiently well settled? That is their secret. The fact is that they have neglected the theoretical demonstration of the existence of a God, and have developed only its practical motives and consequences.","Phil Stamper","390 Pages | 600 Reviews","987 Points",5,R.drawable.book7);
         mdata.add(1,book);
         bookAdapter.notifyItemInserted(1);

     }

     @Override
     public void onBookItemClick(int pos,
                                 ImageView imgBook,
                                 TextView title,
                                 TextView authorName,
                                 TextView nbpages,
                                 TextView score,
                                 RatingBar ratingBar) {


         Intent intent = new Intent(this,BookDetailsActivity.class);
         intent.putExtra("bookObject",mdata.get(pos));

         // shared Animation setup
         androidx.core.util.Pair<View,String> p1 = androidx.core.util.Pair.create((View)imgBook,"bookTN"); // second arg is the tansition string Name
         androidx.core.util.Pair<View,String> p2 = androidx.core.util.Pair.create((View)title,"booktitleTN"); // second arg is the tansition string Name
         androidx.core.util.Pair<View,String> p3 = androidx.core.util.Pair.create((View)authorName,"authorTN"); // second arg is the tansition string Name
         androidx.core.util.Pair<View,String> p4 = androidx.core.util.Pair.create((View)nbpages,"bookpagesTN"); // second arg is the tansition string Name
         androidx.core.util.Pair<View,String> p5 = androidx.core.util.Pair.create((View)score,"scoreTN"); // second arg is the tansition string Name
         androidx.core.util.Pair<View,String> p6 = Pair.create((View)ratingBar,"rateTN"); // second arg is the tansition string Name


         ActivityOptionsCompat optionsCompat =
                 ActivityOptionsCompat.makeSceneTransitionAnimation(this,p1,p2,p3,p4,p5,p6);


         // start the activity with scene transition

         if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
             startActivity(intent,optionsCompat.toBundle());
         }
         else
             startActivity(intent);


     }
 }
