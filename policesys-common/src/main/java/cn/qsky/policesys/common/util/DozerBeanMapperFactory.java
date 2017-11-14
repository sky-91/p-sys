package cn.qsky.policesys.common.util;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author qsky
 */
public class DozerBeanMapperFactory {

  private static final Logger LOG = LoggerFactory.getLogger(DozerBeanMapperFactory.class);
  private static final DozerBeanMapper mapper = new DozerBeanMapper();

  public static DozerBeanMapper getMapper() {
    if (CollectionUtils.isEmpty(mapper.getMappingFiles())) {
      List<String> mappingFiles = new ArrayList<>();
      mappingFiles.add("dozer-mapping.xml");
      mapper.setMappingFiles(mappingFiles);
      LOG.debug("Dozer init successfully!");
    }
    return mapper;
  }
}
