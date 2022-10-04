package com.frontend.taskclient.lib.swinglib;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.DimensionUIResource;

import com.frontend.taskclient.lib.httplib.HttpLib;
import com.frontend.taskclient.models.Task;
import com.frontend.taskclient.models.User; 

public class Swingexample {
  private static List<User> user_list;
  private static List<Task> task_list;
  private static JFrame frame_main = new JFrame("Ứng dụng giao việc");
  private static JButton button_load_data = new JButton("Tải dữ liệu người dùng");
  private static JList<User> panel_user_list = new JList<User>();
  private static JList<Task> panel_user_task_list = new JList<Task>();
  private static JPanel panel_main = new JPanel();

  static void update_panel_user_list() {
    user_list = HttpLib.get_all_user();
    panel_user_list.removeAll();
    panel_user_list.setListData(user_list.toArray(new User[0]));
    panel_user_list.addListSelectionListener(new ListSelectionListener() {
      @Override
      public void valueChanged(ListSelectionEvent e) {
        task_list = panel_user_list.getSelectedValue().getUser_task_list();
        update_panel_user_task_list(task_list);
      }
    });
    panel_user_list.revalidate();
    panel_user_list.repaint();
  }

  static void update_panel_user_task_list(List<Task> task_list_) {
    panel_user_task_list.removeAll();
    panel_user_task_list.setListData(task_list_.toArray(new Task[0]));
    panel_user_task_list.revalidate();
    panel_user_task_list.repaint();
  }

  public static void show_screen() {
    button_load_data.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        update_panel_user_list();
      }
    });

    panel_user_list.setLayout(new BoxLayout(panel_user_list, BoxLayout.Y_AXIS));
    panel_user_list.setBackground(Color.GRAY);
    panel_user_list.setPreferredSize(new DimensionUIResource(200, 600));

    panel_user_task_list.setLayout(new BoxLayout(panel_user_task_list, BoxLayout.Y_AXIS));
    panel_user_task_list.setBackground(Color.GRAY);
    panel_user_task_list.setPreferredSize(new DimensionUIResource(200, 600));

    panel_main.setLayout(new BoxLayout(panel_main, BoxLayout.X_AXIS));
    panel_main.add(button_load_data);
    panel_main.add(panel_user_list);
    panel_main.add(panel_user_task_list);
    frame_main.add(panel_main);

    frame_main.pack();
    frame_main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame_main.setVisible(true);

  }
}
