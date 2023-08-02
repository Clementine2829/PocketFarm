package co.za.pocketfarm.fragmenets;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import co.za.pocketfarm.R;
import co.za.pocketfarm.adaptors.BlogPostAdaptor;
import co.za.pocketfarm.adaptors.OrdersAdaptor;
import co.za.pocketfarm.models.BlogPost;
import co.za.pocketfarm.models.Orders;
import co.za.pocketfarm.models.User;

public class BlogPostsFragment extends Fragment {
    public static List<BlogPost> posts = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.blog_post_list, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.blogs_list);
        posts.clear();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        BlogPost p1 = new BlogPost(
                "123",
                "Essential Soil Tips: Unlocking Your Plant's Full Potential",
                "To achieve thriving plants and lush, vibrant leaves, mastering soil management is essential. " +
                        "Start by understanding your soil type—whether it's sandy, clayey, or loamy—so you can tailor " +
                        "your gardening practices accordingly. Different plants have specific soil preferences, " +
                        "and by providing the right environment, you set the foundation for success.\n" +
                        "\n" +
                        "The next step is ensuring your soil is rich in nutrients. Organic matter, like compost " +
                        "and well-rotted manure, works wonders to boost soil fertility. Nutrient-rich soil promotes " +
                        "healthy root development, which in turn, leads to vigorous growth and robust leaves. " +
                        "Regularly amending your soil with organic matter creates a harmonious ecosystem, " +
                        "benefitting your plants and the beneficial organisms living beneath the surface.\n" +
                        "\n" +
                        "In addition to nutrients, soil aeration plays a pivotal role in plant health. " +
                        "Compacted soil restricts root growth and hampers the absorption of essential elements. " +
                        "Aerate your garden beds to allow air and water to penetrate deep into the soil, " +
                        "invigorating the root system and promoting the growth of luxuriant leaves.");

        BlogPost p2 = new BlogPost(
                "5467",
                "Leaf Colors Decoded: Nature's Captivating Language",
                "Every autumn, Mother Nature unveils a breathtaking display of colors in leaves, " +
                        "capturing the essence of seasonal change. These vibrant hues are a result of various pigments " +
                        "working their magic. Chlorophyll, the dominant pigment, gives leaves their green color while " +
                        "playing a critical role in photosynthesis.\n" +
                        "\n" +
                        "As the days grow shorter and temperatures drop, chlorophyll production decreases, " +
                        "allowing other pigments to shine through. Carotenoids, responsible for yellows and oranges, " +
                        "become more prominent, while anthocyanins, responsible for reds and purples, " +
                        "emerge in response to cool temperatures.\n" +
                        "\n" +
                        "This natural display of colors serves a purpose beyond mere aesthetics. " +
                        "The changing pigments act as a sunscreen, protecting leaves from excessive " +
                        "light and enabling them to continue photosynthesis efficiently. " +
                        "Witnessing this captivating language of colors is a testament to the wonders of nature");

        BlogPost p3 = new BlogPost(
                "199",
                "Eco-Friendly Pest Control: Allies in Garden Harmony ",
                "Insects can either be your garden's allies or adversaries, and maintaining a balanced " +
                        "ecosystem is key to successful pest control. Embrace eco-friendly pest management " +
                        "methods by introducing beneficial insects to your garden. Ladybugs are voracious aphid eaters, " +
                        "while lacewings prey on pesky caterpillars and mites.\n" +
                        "\n" +
                        "Encouraging biodiversity in your garden creates a natural buffer against pests. " +
                        "Plant a diverse range of flowers and herbs to attract beneficial insects and pollinators, " +
                        "creating an environment where pest populations are naturally kept in check.\n");
        BlogPost p4 = new BlogPost(
                "255",
                "DIY Garden Remedies: Banishing Pests, the Natural Way",
                "Bid farewell to chemical-laden pesticides and embrace safe, DIY remedies for pest control." +
                        " Neem oil is a powerful and natural insecticide, deterring a wide range of pests while not " +
                        "harming beneficial insects. Dilute neem oil according to the package instructions and " +
                        "spray it on affected plants.\n" +
                        "\n" +
                        "Garlic sprays are another effective solution. Blend garlic bulbs with water and " +
                        "strain the mixture to create a potent garlic concentrate. Dilute this concentrate " +
                        "and spray it on your plants to repel common pests like aphids and beetles.\n" +
                        "\n" +
                        "For caterpillar control, consider using Bt (Bacillus thuringiensis), a naturally " +
                        "occurring soil bacteria that specifically targets caterpillars without harming other " +
                        "organisms. Apply Bt as directed to protect your plants from caterpillar damage.\n" +
                        "\n" +
                        "By utilizing these eco-friendly DIY remedies, you can protect your garden from harmful " +
                        "pests while preserving a healthy environment for both plants and beneficial insects.");
        BlogPost dummy = new BlogPost("", "This is a dummy post", "Click it and see what is going to happen");

        p1.setUserCreated(new User("", "Clementine"));
        p4.setUserCreated(new User("", "Clementine"));

        p1.setLikes(3);
        p2.setLikes(3);

        p3.setDislikes(1);

        p1.setComments(4);
        p2.setComments(13);

        posts.add(p1);
        posts.add(p2);
        posts.add(p3);
        posts.add(p4);
        posts.add(dummy);

        BlogPostAdaptor adapter = new BlogPostAdaptor(getActivity(), posts);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
