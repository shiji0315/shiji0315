import { BasicColumn } from '/@/components/Table';
import { FormSchema } from '/@/components/Table';
import { rules } from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [
  {
    title: '父类ID',
    align: 'center',
    dataIndex: 'pid_dictText',
  },
  {
    title: '编号',
    align: 'center',
    dataIndex: 'nums',
  },
  {
    title: '类型名称',
    align: 'center',
    dataIndex: 'typeName',
  },
  {
    title: '企业id',
    align: 'center',
    dataIndex: 'enterpriseId',
  },
  {
    title: '创建时间',
    align: 'center',
    dataIndex: 'createTime',
  },
  {
    title: '更新时间',
    align: 'center',
    dataIndex: 'updateTime',
  },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
  {
    label: '编号',
    field: 'nums',
    component: 'Input',
    colProps: { span: 6 },
  },
  {
    label: '类型名称',
    field: 'typeName',
    component: 'Input',
    colProps: { span: 6 },
  },
  {
    label: '企业id',
    field: 'enterpriseId',
    component: 'Input',
    colProps: { span: 6 },
  },
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '父类ID',
    field: 'pid',
    component: 'JTreeSelect',
    componentProps: {
      dict: 'zy_cloths_type,nums,id',
      pidValue: '',
    },
  },
  {
    label: '编号',
    field: 'nums',
    component: 'Input',
    dynamicRules: ({ model, schema }) => {
      return [{ required: true, message: '请输入编号!' }];
    },
  },
  {
    label: '类型名称',
    field: 'typeName',
    component: 'Input',
    dynamicRules: ({ model, schema }) => {
      return [{ required: true, message: '请输入类型名称!' }];
    },
  },
  {
    label: '企业id',
    field: 'enterpriseId',
    component: 'Input',
  },
  // TODO 主键隐藏字段，目前写死为ID
  {
    label: '',
    field: 'id',
    component: 'Input',
    show: false,
  },
];

/**
 * 流程表单调用这个方法获取formSchema
 * @param param
 */
export function getBpmFormSchema(_formData): FormSchema[] {
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}
