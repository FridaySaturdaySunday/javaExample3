package test.table;

import java.awt.Dimension;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

public class SimpleTableTest extends JFrame implements TableModelListener {

	public SimpleTableTest() {

		String[] columnNames = { "이름", "주소", "나이", "가입여부" };
		Object[][] data = { { "김철수", "서울", new Integer(24), new Boolean(false) },
							{ "김영희", "부산", new Integer(27), new Boolean(true) },
							{ "이영철", "천안", new Integer(32), new Boolean(false) } };
		
		this.setTitle("JTable test");
		this.setSize(500, 200);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		final JTable table = new JTable(data, columnNames); // JTable : 엑셀같은 표
		table.setPreferredScrollableViewportSize(new Dimension(500, 150));
		table.setFillsViewportHeight(true);
		// 셀이 변경되면 이벤트 작동 처리
		table.getModel().addTableModelListener(this);
		// 컬럼 헤더를 클릭하면 자동 정렬 처리
		table.setAutoCreateRowSorter(true);

		// 주소를 입력할 때 지정된 도시만 입력이 가능하도록 편집기 설정
		TableColumn cityColumn = table.getColumnModel().getColumn(1);
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("서울");
		comboBox.addItem("부산");
		comboBox.addItem("광주");
		comboBox.addItem("대구");
		comboBox.addItem("대전");
		comboBox.addItem("천안");
		cityColumn.setCellEditor(new DefaultCellEditor(comboBox));
		
		// 스크롤판에 테이블 추가
		JScrollPane scrollPane = new JScrollPane(table);
		// 프레임에 스크롤판 추가
		this.add(scrollPane);
		this.setVisible(true);
	}

	@Override
	public void tableChanged(TableModelEvent event) {  // TODO ??????????
		// 테이블의 내용이 변경되었을 때 작동됨
		int row = event.getFirstRow();
		int column = event.getColumn();
		if (column == 2) {
			TableModel model = (TableModel) event.getSource();
			String columnName = model.getColumnName(column);
			Object data = model.getValueAt(row, column);
			String s = (String) data;
			if (Integer.parseInt(s) > 100) {
				JOptionPane.showMessageDialog(this, "범위를 초과하였습니다." + s, "경고", JOptionPane.WARNING_MESSAGE);
			}
		}
	}

	public static void main(String[] args) {
		// JTable test
		new SimpleTableTest();
	}
}
