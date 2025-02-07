# **Foodig Documentation**  

## **Introduction**  
Do you often forget about the food in your refrigerator, leading to waste due to expiration? This **Java-based desktop application** is here to solve that problem!  

Foodig provides a **visualized record** of food items in your fridge, helping users track expiration dates. It also features a **pet-raising system**, where users earn **virtual currency** by regularly consuming stored food before expiration. This currency can be used to **purchase pets and special items**, encouraging users to engage with the app.  

---

## **GUI Overview**  

### **Startup Screen**  
<img src="https://github.com/yensha/Foodig/blob/main/Img&video/%E8%9E%A2%E5%B9%95%E6%93%B7%E5%8F%96%E7%95%AB%E9%9D%A2%202024-06-05%20063257.png?raw=true" width="250">

### **Home Page**
<img src="https://github.com/yensha/Foodig/blob/main/Img&video/%E8%9E%A2%E5%B9%95%E6%93%B7%E5%8F%96%E7%95%AB%E9%9D%A2%202024-06-05%20063241.png?raw=true" width="250">
Foodig automatically categorizes food into three sections based on expiration status:  
- **Fresh**: Not yet expired  
- **Expiring Soon**: Close to expiration  
- **Expired**: No longer safe to consume  

### **Sidebar Menu**  
Users can navigate through different sections by clicking the corresponding buttons on the sidebar.  
<img src="https://github.com/yensha/Foodig/blob/main/Img&video/%E8%9E%A2%E5%B9%95%E6%93%B7%E5%8F%96%E7%95%AB%E9%9D%A2%202024-06-05%20063310.png?raw=true" width="250">

#### **Sidebar Features**  
- **Add Food**  
  - Input food information  
  - Add new food items
  <img src="https://github.com/yensha/Foodig/blob/main/Img&video/%E8%9E%A2%E5%B9%95%E6%93%B7%E5%8F%96%E7%95%AB%E9%9D%A2%202024-06-05%20063024.png?raw=true" width="250">
- **Foods**  
  - Categorize food items based on expiration date
  <img src="https://github.com/yensha/Foodig/blob/main/Img&video/%E8%9E%A2%E5%B9%95%E6%93%B7%E5%8F%96%E7%95%AB%E9%9D%A2%202024-06-05%20021832.png?raw=true" width="250">
- **Game (Food / Shop)**  
  - Eat food before expiration to earn pet food and feed virtual mice.  
  - Mice generate **gold coins**, which can be used to **buy new mice or special items**.  
  - If food expires, **mice get poisoned** and stop generating coins.  
  <img src="https://github.com/yensha/Foodig/blob/main/Img&video/%E8%9E%A2%E5%B9%95%E6%93%B7%E5%8F%96%E7%95%AB%E9%9D%A2%202024-06-05%20063436.png?raw=true" width="250">
  <img src="https://github.com/yensha/Foodig/blob/main/Img&video/%E8%9E%A2%E5%B9%95%E6%93%B7%E5%8F%96%E7%95%AB%E9%9D%A2%202024-06-05%20063506.png?raw=true" width="250">
---

## **Class Diagram**  
![Class Diagram](https://github.com/yensha/Foodig/blob/main/Img&video/%E8%9E%A2%E5%B9%95%E6%93%B7%E5%8F%96%E7%95%AB%E9%9D%A2%202025-02-08%20012429.png?raw=true)

---

## **Problems & Solutions**  

### **1. Android App Development**  
**Problem**: We originally planned to develop a mobile app but were unfamiliar with Android Studio.  
**Solution**: We switched to **JavaFX for a desktop application**, leveraging our course knowledge.  

### **2. GUI Enhancement**  
**Problem**: We wanted a more visually appealing UI but found Swing too limiting.  
**Solution**: We opted for **JavaFX**, learning more advanced GUI implementation techniques.  

### **3. Sharing Data Across Controllers**  
**Problem**: Multiple controllers needed access to the same class data.  
**Solution**: We converted shared data into **static variables and methods**, allowing seamless access across controllers.  

### **4. Continuous Data Retrieval and Function Execution**  
**Problem**: The application required constant updates to fetch and display data.  
**Solution**: We implemented a **Timer** to repeatedly execute functions, ensuring real-time UI updates.  

---

## **Future Improvements**  

### **1. Food Database Integration**  
- Develop a structured **food database** for better tracking.  

### **2. Image Input for Food Recognition**  
- **Image Capture**: Use **webcam** to capture food images.  
- **OCR (Optical Character Recognition)**: Recognize food labels and expiration dates.  
- **Deep Learning**: Predict expiration dates based on food type and category.  

---

## **Demo Video**  
[Watch Demo on GitHub](https://youtube.com/shorts/yveLIEXB4uA?feature=share)

---

This Markdown file is fully formatted with **headers, lists, images, and links**.  
Just replace `"path/to/your_image.png"` with actual image links and update the **demo video link** accordingly. 🚀  
Let me know if you need further modifications!
