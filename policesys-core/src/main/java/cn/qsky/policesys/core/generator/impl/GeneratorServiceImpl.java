package cn.qsky.policesys.core.generator.impl;

import cn.qsky.policesys.core.generator.GeneratorService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author qsky on 17/11/13
 */
@Service
public class GeneratorServiceImpl implements GeneratorService {

  @Resource
  private PkGenerator pkGenerator;

  @Override
  public Long generatePK() {
    return pkGenerator.nextId();
  }
}
