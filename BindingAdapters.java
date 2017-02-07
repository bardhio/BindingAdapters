


public class BindingAdapters {
  //Load a pic into imageview with Glide
  @BindingAdapter("android:src")
  public static void setImageResource(ImageView imageView, int resource) {
    Glide.with(imageView.getContext()).load(resource).into(imageView);

  }
//Set a src of imageview a vector
  @BindingAdapter("vectorResource")
  public static void setvectorResource(ImageView imageView, int resource) {
    imageView.setImageResource(resource);
  }
//Set dividers to a recyclerview
  @BindingAdapter("dividers")
  public static void setDividers(RecyclerView view, int resource) {
    Drawable dividerDrawable = ContextCompat.getDrawable(view.getContext(), resource);
    view.addItemDecoration(new SimpleDividerItemDecoration(dividerDrawable));
  }
//Load an online url image using glide
  @BindingAdapter("android:onlineSrc")
  public static void setOnlineResource(ImageView imageView, String url) {
    Glide.with(imageView.getContext()).load(url).into(imageView);
  }
//Load a picture directly from firebase
  @BindingAdapter("android:firebaseLoad")
  public static void setFirebaseImage(ImageView imageView, String profilePicture) {
    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference storageRef = storage.getReferenceFromUrl(profilePicture);
    Glide.with(imageView.getContext())
      .using(new FirebaseImageLoader())
      .load(storageRef)
      .into(imageView);
  }
  //A textvie with capital initlas to firstName and lastName
  @BindingAdapter({"bind:firstName", "bind:lastName"})
  public static void firstLetters(TextView first,String first_name,String last_name) {
    first.setText(first_name.substring(0,1).toUpperCase()+last_name.substring(0,1).toUpperCase());
  }

}








