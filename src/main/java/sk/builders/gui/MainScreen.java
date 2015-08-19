package sk.builders.gui;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import sk.builders.core.annotations.Autowired;
import sk.builders.game.bo.Castle;
import sk.builders.game.bo.Building;
import sk.builders.game.bo.Map;
import sk.builders.game.bo.Position;
import sk.builders.game.bo.Terrain;
import sk.builders.game.interfaces.GameApi;
import sk.builders.utils.Utils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainScreen {

	@Autowired
	private DisplayMap displayMap;
	@Autowired
	private GameApi gameApi;
	@Autowired
	private Map map;

	private Castle base;

	public void draw() {
		JFrame guiFrame = new JFrame();

		guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		guiFrame.setTitle("Builders");
		guiFrame.setSize(640, 480);
		guiFrame.setLocationRelativeTo(null);
		final JPanel panel = new JPanel();

		JButton build = new JButton("build");
		JButton destroy = new JButton("destroy");
		displayMap.setPreferredSize(new Dimension(640 - 32, 640 - 32));
		panel.add(build);
		panel.add(destroy);
		panel.add(displayMap);
		guiFrame.add(panel);

		build.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Position position = new Position(0, 0);
				base = new Castle(position);
				System.out.println(gameApi.build(base, position).isResult());
				displayMap.repaint();
			}
		});

		destroy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Position position = new Position(0, 0);
				System.out.println(gameApi.destroy(position).isResult());
				displayMap.repaint();
			}
		});

		displayMap.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {

				Position position = Utils.calculateReverse(new Position(e
						.getX(), e.getY()));
				System.out.println(new Position(e.getX(), e.getY()));

				if (SwingUtilities.isLeftMouseButton(e)) {
					Building building = new Castle(position);
					// System.out.println("toto sleduj: " +
					
					boolean contains = Utils.containsPoint(base.getPolygon(),
							e.getX(), e.getY());
					System.out.println("obsahuje: " + contains);
					// e.getX(), e.getY()));
					// System.out.println(gameApi.build(building,
					// position).isResult());
				} else if (SwingUtilities.isRightMouseButton(e)) {
					System.out.println(gameApi.destroy(position).isResult());
				}
				displayMap.repaint();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		guiFrame.setVisible(true);
	}
}
