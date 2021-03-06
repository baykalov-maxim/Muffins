package ua.nure.muffins.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ua.nure.muffins.dao.MuffinDao;
import ua.nure.muffins.dto.MuffinDto;
import ua.nure.muffins.model.Muffin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class MuffinDaoImpl implements MuffinDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<MuffinDto> mapper = new RowMapper<MuffinDto>() {
        @Override
        public MuffinDto mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new MuffinDto(rs.getLong("id_muffin"),
                    rs.getString("name_muffin"),
                    rs.getString("desc_muffin"),
                    rs.getInt("price_muffin"),
                    rs.getString("img_muffin"));
        }
    };


    @Override
    public List<MuffinDto> getAll() {
        return jdbcTemplate.query("Select id_muffin, name_muffin, desc_muffin, price_muffin, img_muffin from t_muffin", mapper);
    }

    @Override
    public List<MuffinDto> getRandom() {
        return jdbcTemplate.query("call p_get_random_muffins()", mapper);
    }

    @Override
    public void deleteAll() {
        jdbcTemplate.execute("DELETE FROM t_muffin WHERE id_muffin <> id_muffin + 1");
    }
}
